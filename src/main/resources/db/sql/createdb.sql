--DROP TABLE textpad IF EXISTS;

CREATE TABLE textpad (
  id   INTEGER PRIMARY KEY,
  texttitle VARCHAR(50),
  textdesc  VARCHAR(500),
  creationDate DATETIME
);
