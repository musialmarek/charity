
INSERT INTO charity.categories (id, name) VALUES (1, 'ubrania');
INSERT INTO charity.categories (id, name) VALUES (2, 'zabawki');
INSERT INTO charity.categories (id, name) VALUES (3, 'agd i rtv');
INSERT INTO charity.categories (id, name) VALUES (4, 'meble');
INSERT INTO charity.categories (id, name) VALUES (5, 'inne');

INSERT INTO charity.institutions (id, description, name) VALUES (1, 'Troszczymy się o najuboższych.', 'Pomagamy');
INSERT INTO charity.institutions (id, description, name) VALUES (2, 'Naszym celem jest pomoc rodzinom, które ucierpiały z powodu klęsk żywiołowych', 'Lepsze jutro');
INSERT INTO charity.institutions (id, description, name) VALUES (3, 'Chcemy, aby każdy bezdomny czuł, że ma miejsce na ziemi, gdzie będzie czuł się bezpieczny, bez mrozu i głodu.', 'Twój dom');
INSERT INTO charity.institutions (id, description, name) VALUES (4, 'Cel i misja: pomoc osobom, którzy z powodu długów muszą ogłosić upadłość majątkową', 'Nowy Start');

INSERT INTO charity.donations (id, city, picku_up_comment, pick_up_date, pick_up_time, quantity, street, zip_code, institution_id) VALUES (1, 'Wrocław', 'na przystanku autobusowym', '2020-10-11', '12:00:00', 3, 'Zielona 7', '50-123', 1);
INSERT INTO charity.donations (id, city, picku_up_comment, pick_up_date, pick_up_time, quantity, street, zip_code, institution_id) VALUES (2, 'Warszawa', 'koło biedronki', '2020-10-12', '15:00:00', 1, 'Piłsudskiego 12', '00-123', 2);
INSERT INTO charity.donations (id, city, picku_up_comment, pick_up_date, pick_up_time, quantity, street, zip_code, institution_id) VALUES (3, 'Poznań', 'koło poczty', '2020-10-13', '13:00:00', 1, 'Al. Jerozolimskie 33', '33-123', 3);
INSERT INTO charity.donations (id, city, picku_up_comment, pick_up_date, pick_up_time, quantity, street, zip_code, institution_id) VALUES (4, 'Kraków', 'przed domem', '2020-10-14', '18:00:00', 2, 'Pocztowa 2', '14-156', 4);

INSERT INTO charity.donations_categories (donation_id, category_id) VALUES (2, 1);
INSERT INTO charity.donations_categories (donation_id, category_id) VALUES (3, 1);
INSERT INTO charity.donations_categories (donation_id, category_id) VALUES (1, 2);
INSERT INTO charity.donations_categories (donation_id, category_id) VALUES (1, 3);
INSERT INTO charity.donations_categories (donation_id, category_id) VALUES (2, 3);
INSERT INTO charity.donations_categories (donation_id, category_id) VALUES (4, 4);
INSERT INTO charity.donations_categories (donation_id, category_id) VALUES (4, 5);