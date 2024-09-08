
CREATE TABLE IF NOT EXISTS  note (
               id INT AUTO_INCREMENT PRIMARY KEY,
               title VARCHAR(250)    NOT  NULL  CHECK ( LENGTH (title)>=1 ),
               content VARCHAR(1000)    NOT  NULL  CHECK ( LENGTH (content)>=2 ));

