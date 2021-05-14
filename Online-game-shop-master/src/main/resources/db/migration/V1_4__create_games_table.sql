CREATE TABLE IF NOT EXISTS games (
          game_id serial PRIMARY KEY,
          game_name varchar(255) NOT NULL,
          game_author varchar(255) NOT NULL,
          game_img varchar(255) NOT NULL,
          game_description varchar(255) NOT NULL,
          game_price double precision NOT NULL,
          game_year integer NOT NULL
);
