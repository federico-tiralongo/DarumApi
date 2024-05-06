-- Users
INSERT INTO public.usuario (id,nombre,email,contrasena)
	VALUES (1,'Juanito','juanito@email.com','plaintext')
    ON CONFLICT DO NOTHING;
INSERT INTO public.usuario (id,nombre,email,contrasena)
	VALUES (2,'Pepito','pepito@email.com','plaintext')
    ON CONFLICT DO NOTHING;

-- Colors
INSERT INTO public.color (id,color,tipo)
	VALUES (1,'ROJO','ROJO')
    ON CONFLICT DO NOTHING;
INSERT INTO public.color (id,color,tipo)
	VALUES (2,'AZUL','AZUL')
    ON CONFLICT DO NOTHING;
INSERT INTO public.color (id,color,tipo)
	VALUES (3,'AMARILLO','AMARILLO')
    ON CONFLICT DO NOTHING;
INSERT INTO public.color (id,color,tipo)
	VALUES (4,'ROSA','ROSA')
    ON CONFLICT DO NOTHING;

--Darumas
INSERT INTO public.daruma (id,left_eye,right_eye,objetivo,color,skin)
	VALUES (1,true,true,'Primer objetivo',1,null)
    ON CONFLICT DO NOTHING;
INSERT INTO public.daruma (id,left_eye,right_eye,objetivo,color,skin)
	VALUES (2,true,true,'Segundo objetivo',2,null)
    ON CONFLICT DO NOTHING;
INSERT INTO public.daruma (id,left_eye,right_eye,objetivo,color,skin)
	VALUES (3,true,false,'Tercer objetivo',3,null)
    ON CONFLICT DO NOTHING;
INSERT INTO public.daruma (id,left_eye,right_eye,objetivo,color,skin)
	VALUES (4,false,false,'Cuarto objetivo',1,null)
    ON CONFLICT DO NOTHING;
INSERT INTO public.daruma (id,left_eye,right_eye,objetivo,color,skin)
	VALUES (5,false,true,'Quinto objetivo',3,null)
    ON CONFLICT DO NOTHING;

-- Skin
INSERT INTO public.skins (id,skin)
	VALUES (1,'MARBLE')
    ON CONFLICT DO NOTHING;
INSERT INTO public.skins (id,skin)
	VALUES (2,'GOKU')
    ON CONFLICT DO NOTHING;
INSERT INTO public.skins (id,skin)
	VALUES (3,'DEADPOOL')
    ON CONFLICT DO NOTHING;
INSERT INTO public.skins (id,skin)
	VALUES (4,'GRASS')
    ON CONFLICT DO NOTHING;