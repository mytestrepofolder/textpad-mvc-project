package com.edia.mvc.textpad.dao;

/**
 * @Author: Plabon Kakoti
 * @Date: 05/06/2017
 */

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import com.edia.mvc.textpad.entity.TextPad;

@Repository
public class TextPadDAOImpl implements TextPadDAO {

	private static final AtomicLong counter = new AtomicLong();

	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
		counter.set(3);
	}

	@Override
	public List<TextPad> getAllTexts() {

		Map<String, Object> params = new HashMap<String, Object>();
		String sql = "SELECT * FROM textpad ORDER by creationDate DESC";
		List<TextPad> result = namedParameterJdbcTemplate.query(sql, params, new TextPadMapper());
		System.out.println("Total number of Texts : " + result.size());
		return result;

	}

	@Override
	public void addText(TextPad text) {
		Date date = new Date();
		// java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		java.sql.Timestamp sqlDateTime = new Timestamp(date.getTime());
		String query = "insert into textpad (id,texttitle,textdesc,creationDate) values (:id,:texttitle,:textdesc,:creationDate)";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", counter.incrementAndGet());
		map.put("texttitle", text.getTextTilte());
		map.put("textdesc", text.getTextDesc());
		map.put("creationDate", sqlDateTime);
		namedParameterJdbcTemplate.update(query, map);

	}

	@Override
	public void updateText(TextPad text) {
		String update = "UPDATE textpad SET texttitle = :texttitle ,textdesc = :textdesc WHERE id = :id";
		SqlParameterSource params = new MapSqlParameterSource().addValue("texttitle", text.getTextTilte())
				.addValue("textdesc", text.getTextDesc()).addValue("id", text.getId());
		namedParameterJdbcTemplate.update(update, params);
	}

	@Override
	public TextPad getTextById(int id) {

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);

		String sql = "SELECT * FROM textpad WHERE id = :id";
		TextPad result = namedParameterJdbcTemplate.queryForObject(sql, params, new TextPadMapper());
		return result;
	}

	private static final class TextPadMapper implements RowMapper<TextPad> {

		public TextPad mapRow(ResultSet rs, int rowNum) throws SQLException {
			TextPad text = new TextPad();
			text.setId(rs.getInt("id"));
			text.setTextTilte(rs.getString("texttitle"));
			text.setTextDesc(rs.getString("textdesc"));
			text.setCreationDate(new DateTime(rs.getTimestamp("creationDate")));
			return text;
		}
	}
}
