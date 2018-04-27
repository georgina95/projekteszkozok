INSERT INTO user (id, nickname, name, email, phone_number, user_type) VALUES (1, 'VBela67', 'Végh Béla', 'vegh.b@business.hu', '06909538546', 'USER');
INSERT INTO user (id, nickname, name, email, phone_number, user_type) VALUES (2, 'KJozsef78', 'Kalmár József', 'kalmar.j@business.hu', '06901742356', 'USER');
INSERT INTO user (id, nickname, name, email, phone_number, user_type) VALUES (3, 'BLaszlo93', 'Békés László', 'bekes.l@business.hu', '06901798626', 'OPERATOR');
INSERT INTO user (id, nickname, name, email, phone_number, user_type) VALUES (4, 'LPetra86', 'Lámpás Petra', 'lampas.p@business.hu', '06907334982', 'ADMIN');




INSERT INTO report (id, report_date, reporter_id, operator_id, status) VALUES (1, '2017-10-20 09:00:00', 1, 3, 'IN_PROGRESS');
INSERT INTO report (id, report_date, reporter_id, operator_id, status) VALUES (2, '2017-07-02 16:00:00', 2, 3, 'SOLVED');



INSERT INTO states 	(id, triggered_by_id, state_date, commen, owner_id, status, report_id)
			VALUES 	(0, 1, '2017-10-20 09:00:00', 'Kiégett az izzó a 12. emeleti mosdóban.', 1, 'OPEN', 1);
INSERT INTO states 	(id, triggered_by_id, state_date, commen, owner_id, status, report_id)
			VALUES 	(1, 3, '2017-10-21 12:20:00', 'Felveszem a bejelentést, hamarosan beszerzem az új izzókat.', 3, 'IN_PROGRESS', 1);
			
INSERT INTO states 	(id, triggered_by_id, state_date, commen, owner_id, status, report_id)
			VALUES 	(2, '2017-07-02 16:00:00', 'Beletört a kulcs az irodám ajtajának zárjába. Sürgősen javítást kérek.', 1, 'OPEN', 2)
INSERT INTO states 	(id, triggered_by_id, state_date, commen, owner_id, status, report_id)
			VALUES 	(3, 3, '2017-07-02 16:30:00', 'Felveszem a bejelentést, két órán belül kicserélem a zárat.', 3, 'IN_PROGRESS', 2);
INSERT INTO states 	(id, triggered_by_id, state_date, commen, owner_id, status, report_id)
			VALUES 	(4, 3, '2017-07-02 17:45:00', 'Kicseréltem a zárat, az új kulcsokat leadtam az iroda tulajdonosának.', 3, 'SOLVED', 2);
