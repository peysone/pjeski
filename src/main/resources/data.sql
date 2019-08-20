INSERT INTO shelter(id, account_number, address, city, name, postal_code, telephone)
VALUES ('1', '112323124', 'Grunwaldzka', 'Gdańsk', 'Promyk', '80-180', '20328411');

INSERT INTO shelter(id, account_number, address, city, name, postal_code, telephone)
VALUES ('2', '00932313', 'Gdańska', 'Sopot', 'Promyk ale w sopocie', '80-180', '43243242');

INSERT INTO shelter(id, account_number, address, city, name, postal_code, telephone)
VALUES ('3', '00032130023', 'Owocowa', 'Warszawa', 'Stolicowo', '80-180', '99437472');

INSERT INTO shelter(id, account_number, address, city, name, postal_code, telephone)
VALUES ('4', '00932832', 'Pieskowa', 'Gdańsk', 'Łapa', '80-180', '4324238');

INSERT INTO shelter(id, account_number, address, city, name, postal_code, telephone)
VALUES ('5', '82731237', 'Kotkowa', 'Bydgoszcz', 'Bydgoszczowo', '80-180', '20328411');

    INSERT INTO user(user_id, active, address, city, email, first_name, last_name, password, postal_code)
    VALUES ('1', '1', 'Cebertowicza', 'Gdansk', 'dd@wp.pl', 'Adrian', 'Kdr', '$2a$10$7OoVsugEZnz4KPq.9SpIu.rJgm3T.WQ0eNCw2wZB78xQkq63VygpC', '80-210');

    INSERT INTO user(user_id, active, address, city, email, first_name, last_name, password, postal_code)
    VALUES ('2', '1', 'Mickiewicza', 'Gdansk', 'ww@wp.pl', 'Bogdan', 'Miśkiewicz', '$2a$10$7OoVsugEZnz4KPq.9SpIu.rJgm3T.WQ0eNCw2wZB78xQkq63VygpC', '80-210');

    INSERT INTO user(user_id, active, address, city, email, first_name, last_name, password, postal_code)
    VALUES ('3', '1', 'Cebertowicza', 'Gdansk', 'aa@wp.pl', 'Adrian', 'Kdr', '$2a$10$7OoVsugEZnz4KPq.9SpIu.rJgm3T.WQ0eNCw2wZB78xQkq63VygpC', '80-210');

    INSERT INTO user(user_id, active, address, city, email, first_name, last_name, password, postal_code)
    VALUES ('4', '1', 'Cebertowicza', 'Gdansk', 'bb@wp.pl', 'Adrian', 'Kdr', '$2a$10$7OoVsugEZnz4KPq.9SpIu.rJgm3T.WQ0eNCw2wZB78xQkq63VygpC', '80-210');


    INSERT INTO role(role_id, role)
    VALUES ('1', 'ROLE_ADMIN');

    INSERT INTO role(role_id, role)
    VALUES ('3', 'ROLE_USER');

    INSERT INTO role(role_id, role)
    VALUES ('2', 'ROLE_ADMIN_SHELTER');


    INSERT INTO user_role(user_id, role_id)
    VALUES ('1', '1');

    INSERT INTO user_role(user_id, role_id)
    VALUES ('2', '3');

    INSERT INTO user_role(user_id, role_id)
    VALUES ('3', '2');
    INSERT INTO user_role(user_id, role_id)
    VALUES ('4', '3');



INSERT INTO animal(id, animal_sex, animal_type, breed, date_since_in_shelter, description, estimated_age, identification_number, is_available_forAWalk, is_available_to_adoption, is_purebred, name, shelter_id)
VALUES ('1', '0', '0', 'owczarek niemiecki', '12.12.12', 'tu jest opis', '9', '123123', 'true', 'true', 'false', 'Heinz', '1');

INSERT INTO animal(id, animal_sex, animal_type, breed, date_since_in_shelter, description, estimated_age, identification_number, is_available_forAWalk, is_available_to_adoption, is_purebred, name, shelter_id)
VALUES ('2', '2', '0', 'husky', '12.12.12', 'tu jest opis', '9', '123123', 'true', 'true', 'false', 'Demon', '5');

INSERT INTO animal(id, animal_sex, animal_type, breed, date_since_in_shelter, description, estimated_age, identification_number, is_available_forAWalk, is_available_to_adoption, is_purebred, name, shelter_id)
VALUES ('3', '0', '0', 'ciapak', '12.12.12', 'tu jest opis', '9', '123123', 'true', 'true', 'false', 'Ciapek', '2');

INSERT INTO animal(id, animal_sex, animal_type, breed, date_since_in_shelter, description, estimated_age, identification_number, is_available_forAWalk, is_available_to_adoption, is_purebred, name, shelter_id)
VALUES ('4', '1', '1', 'ragdoll', '12.12.12', 'tu jest opis', '9', '123123', 'true', 'true', 'false', 'Kotel', '1');

INSERT INTO animal(id, animal_sex, animal_type, breed, date_since_in_shelter, description, estimated_age, identification_number, is_available_forAWalk, is_available_to_adoption, is_purebred, name, shelter_id)
VALUES ('5', '0', '0', 'ból dog', '12.12.12', 'jak sie nazywa pies ktorego cos boli', '9', '123123', 'true', 'true', 'false', 'Ryszard', '2');

INSERT INTO animal(id, animal_sex, animal_type, breed, date_since_in_shelter, description, estimated_age, identification_number, is_available_forAWalk, is_available_to_adoption, is_purebred, name, shelter_id)
VALUES ('6', '0', '0', 'kundel', '12.12.12', 'tu jest opis', '9', '123123', 'true', 'true', 'false', 'Spike', '4');

INSERT INTO animal(id, animal_sex, animal_type, breed, date_since_in_shelter, description, estimated_age, identification_number, is_available_forAWalk, is_available_to_adoption, is_purebred, name, shelter_id)
VALUES ('7', '0', '0', 'kundel', '12.12.12', 'tu jest opis', '9', '123123', 'true', 'true', 'false', 'Bruno', '3');

INSERT INTO animal(id, animal_sex, animal_type, breed, date_since_in_shelter, description, estimated_age, identification_number, is_available_forAWalk, is_available_to_adoption, is_purebred, name, shelter_id)
VALUES ('8', '0', '0', 'ds', '12.12.12', 'opis', '9', '123123', 'true', 'true', 'true', 'Max', '2');

INSERT INTO animal(id, animal_sex, animal_type, breed, date_since_in_shelter, description, estimated_age, identification_number, is_available_forAWalk, is_available_to_adoption, is_purebred, name, shelter_id)
VALUES ('9', '0', '0', 'owczarek niemiecki', '12.12.12', 'tu jest opis', '9', '123123', 'true', 'true', 'false', 'Kropek', '2');

INSERT INTO animal(id, animal_sex, animal_type, breed, date_since_in_shelter, description, estimated_age, identification_number, is_available_forAWalk, is_available_to_adoption, is_purebred, name, shelter_id)
VALUES ('10', '0', '0', 'owczarek niemiecki', '12.12.12', 'tu jest opis', '9', '123123', 'true', 'true', 'false', 'Pluto', '4');

INSERT INTO animal(id, animal_sex, animal_type, breed, date_since_in_shelter, description, estimated_age, identification_number, is_available_forAWalk, is_available_to_adoption, is_purebred, name, shelter_id)
VALUES ('11', '0', '0', 'owczarek niemiecki', '12.12.12', 'tu jest opis', '9', '123123', 'true', 'true', 'false', 'Yuki', '1');

INSERT INTO animal(id, animal_sex, animal_type, breed, date_since_in_shelter, description, estimated_age, identification_number, is_available_forAWalk, is_available_to_adoption, is_purebred, name, shelter_id)
VALUES ('12', '0', '0', 'owczarek niemiecki', '12.12.12', 'tu jest opis', '9', '123123', 'true', 'true', 'false', 'Basza', '3');

INSERT INTO animal(id, animal_sex, animal_type, breed, date_since_in_shelter, description, estimated_age, identification_number, is_available_forAWalk, is_available_to_adoption, is_purebred, name, shelter_id)
VALUES ('13', '0', '0', 'kundel', '12.12.12', 'tu jest opis', '9', '123123', 'true', 'true', 'false', 'Azor', '2');