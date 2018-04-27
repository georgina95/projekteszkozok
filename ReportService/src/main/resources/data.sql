INSERT INTO user (nickname, name, email, phone_number, user_type) VALUES ('VBela67', 'Végh Béla', 'vegh.b@business.hu', '06909538546', 'USER');
INSERT INTO user (nickname, name, email, phone_number, user_type) VALUES ('KJozsef78', 'Kalmár József', 'kalmar.j@business.hu', '06901742356', 'USER');
INSERT INTO user (nickname, name, email, phone_number, user_type) VALUES ('BLaszlo93', 'Békés László', 'bekes.l@business.hu', '06901798626', 'OPERATOR');
INSERT INTO user (nickname, name, email, phone_number, user_type) VALUES ('LPetra86', 'Lámpás Petra', 'lampas.p@business.hu', '06907334982', 'ADMIN');




INSERT INTO report (id, report_date, reporter_nickname, operator_nickname, status) VALUES (0, '2017-10-20 09:00:00', 'VBela67', 'BLaszlo93', 'IN_PROGRESS');
INSERT INTO report (id, report_date, reporter_nickname, operator_nickname, status) VALUES (1, '2017-07-02 16:00:00', 'KJozsef78', 'BLaszlo93', 'SOLVED');



INSERT INTO state 	(id, number, triggered_by_nickname, state_date, comment, owner_nickname, status, report_id) VALUES 	(0,0, 'VBela67', '2017-10-20 09:00:00', 'Kiégett az izzó a 12. emeleti mosdóban.', 'VBela67', 'OPEN', 0);
INSERT INTO state 	(id, number, triggered_by_nickname, state_date, comment, owner_nickname, status, report_id) VALUES 	(1,1, 'BLaszlo93', '2017-10-21 12:20:00', 'Felveszem a bejelentést, hamarosan beszerzem az új izzókat.', 'BLaszlo93', 'IN_PROGRESS', 0);
			
INSERT INTO state 	(id, number, triggered_by_nickname, state_date, comment, owner_nickname, status, report_id) VALUES 	(2,0, 'BLaszlo93', '2017-07-02 16:00:00', 'Beletört a kulcs az irodám ajtajának zárjába. Sürgősen javítást kérek.', 'VBela67', 'OPEN', 1);
INSERT INTO state 	(id, number, triggered_by_nickname, state_date, comment, owner_nickname, status, report_id) VALUES 	(3,1, 'BLaszlo93', '2017-07-02 16:30:00', 'Felveszem a bejelentést, két órán belül kicserélem a zárat.', 'BLaszlo93', 'IN_PROGRESS', 1);
INSERT INTO state 	(id, number, triggered_by_nickname, state_date, comment, owner_nickname, status, report_id) VALUES 	(4,2, 'BLaszlo93', '2017-07-02 17:45:00', 'Kicseréltem a zárat, az új kulcsokat leadtam az iroda tulajdonosának.', 'BLaszlo93', 'SOLVED', 1);
