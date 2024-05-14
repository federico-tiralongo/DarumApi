alter table usuario drop column authorities;
alter table usuario drop column firebase_user_id;
ALTER TABLE usuario ADD COLUMN password varchar(255);