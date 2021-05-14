CREATE TABLE IF NOT EXISTS carts (
          cart_id serial PRIMARY KEY,
          amount integer NOT NULL,
          game_name varchar(255) NOT NULL,
          cost double precision NOT NULL,
          total_cost double precision NOT NULL,
          user_id integer NOT NULL
);
