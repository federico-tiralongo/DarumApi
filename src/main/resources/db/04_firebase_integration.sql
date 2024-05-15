alter table usuario add column authorities varchar(255);
alter table usuario add column firebase_user_id varchar(64);
alter table usuario drop column password;