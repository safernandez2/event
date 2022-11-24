CREATE TABLE IF NOT EXISTS event(
id SERIAL,
description VARCHAR(100) NOT NULL,
start_date DATE NULL,
end_date DATE NULL,
city VARCHAR(50) NOT NULL,
PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS conference(
id SERIAL,
title VARCHAR(100) NOT NULL,
speaker VARCHAR(100),
hora  VARCHAR(50) NOT NULL,
event_id INT NOT NULL,
PRIMARY KEY(id),
FOREIGN KEY(event_id) REFERENCES event (id)
);

CREATE TABLE IF NOT EXISTS member_event(
id SERIAL,
member_id INT NOT NULL,
event_id INT NOT NULL,
PRIMARY KEY(id),
FOREIGN KEY(member_id) REFERENCES member (id),
FOREIGN KEY(event_id) REFERENCES event (id)
);