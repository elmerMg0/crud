--
-- PostgreSQL database dump
--

-- Dumped from database version 14.9 (Ubuntu 14.9-0ubuntu0.22.04.1)
-- Dumped by pg_dump version 14.9 (Ubuntu 14.9-0ubuntu0.22.04.1)

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: rol; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.rol (
                            id integer NOT NULL,
                            name character varying(100) NOT NULL
);


ALTER TABLE public.rol OWNER TO postgres;

--
-- Name: rol_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.rol_sequence
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.rol_sequence OWNER TO postgres;

--
-- Name: user_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.user_sequence
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.user_sequence OWNER TO postgres;

--
-- Name: usuario; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.usuario (
                                id integer NOT NULL,
                                username character varying(150) NOT NULL,
                                password character varying(150) NOT NULL,
                                email character varying(150) NOT NULL,
                                created_at timestamp without time zone DEFAULT now()
);


ALTER TABLE public.usuario OWNER TO postgres;

--
-- Name: usuario_detail; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.usuario_detail (
                                       id integer NOT NULL,
                                       first_name character varying(100) NOT NULL,
                                       last_name character varying(100) NOT NULL,
                                       age integer,
                                       birth_day date,
                                       usuario_id integer
);


ALTER TABLE public.usuario_detail OWNER TO postgres;

--
-- Name: usuario_detail_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.usuario_detail_sequence
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.usuario_detail_sequence OWNER TO postgres;

--
-- Name: usuario_rol; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.usuario_rol (
                                    id integer NOT NULL,
                                    active boolean NOT NULL,
                                    created_at timestamp without time zone DEFAULT now() NOT NULL,
                                    usuario_id integer,
                                    rol_id integer
);


ALTER TABLE public.usuario_rol OWNER TO postgres;

--
-- Name: usuario_rol_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.usuario_rol_sequence
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.usuario_rol_sequence OWNER TO postgres;

--
-- Data for Name: rol; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.rol (id, name) FROM stdin;
6	Admin again
7	cajero
\.


--
-- Data for Name: usuario; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.usuario (id, username, password, email, created_at) FROM stdin;
100	elmermendoz	123	elmer@gmail.ocm	\N
101	Usuario	1234	usuario2@gmail.com	2023-11-21 11:48:58.89542
2	elmerneodza	password	norepl@!gmaill.com	\N
3	elmerneodza	password	norepl@!gmaill.com	\N
4	elmerneodza	password	norepl@!gmaill.com	\N
5	elmerneodza	password	norepl@!gmaill.com	\N
6	elmerneodza	password	norepl@!gmaill.com	\N
7	nombre_de_usuario	contrasena	correo@ejemplo.com	\N
8	nombre_de_usuario	contrasena	correo@ejemplo.com	\N
9	nombre_de_usuario2	contrasena	correo@ejemplo.com	\N
10	nombre_de_usuario	contrasena	correo@ejemplo.com	\N
13	UsuairoTransaction	contrasena2	correo@ejemplo.com	\N
\.


--
-- Data for Name: usuario_detail; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.usuario_detail (id, first_name, last_name, age, birth_day, usuario_id) FROM stdin;
7	Nombre	Apellido	25	1998-01-14	8
8	Nombre2	Apellido	25	1998-01-14	10
9	Transacion	Transaction	23	\N	13
\.


--
-- Data for Name: usuario_rol; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.usuario_rol (id, active, created_at, usuario_id, rol_id) FROM stdin;
5	t	2023-11-22 08:49:03.094531	13	7
4	f	2023-11-22 08:45:44.197523	13	6
\.


--
-- Name: rol_sequence; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.rol_sequence', 7, true);


--
-- Name: user_sequence; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.user_sequence', 14, true);


--
-- Name: usuario_detail_sequence; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.usuario_detail_sequence', 9, true);


--
-- Name: usuario_rol_sequence; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.usuario_rol_sequence', 5, true);


--
-- Name: rol rol_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.rol
    ADD CONSTRAINT rol_pkey PRIMARY KEY (id);


--
-- Name: usuario_detail usuario_detail_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usuario_detail
    ADD CONSTRAINT usuario_detail_pkey PRIMARY KEY (id);


--
-- Name: usuario usuario_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT usuario_pkey PRIMARY KEY (id);


--
-- Name: usuario_rol usuario_rol_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usuario_rol
    ADD CONSTRAINT usuario_rol_pkey PRIMARY KEY (id);


--
-- Name: usuario_detail fk_usuariodetail_refusuairo; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usuario_detail
    ADD CONSTRAINT fk_usuariodetail_refusuairo FOREIGN KEY (usuario_id) REFERENCES public.usuario(id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- Name: usuario_rol fk_usuariorol_refrol; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usuario_rol
    ADD CONSTRAINT fk_usuariorol_refrol FOREIGN KEY (rol_id) REFERENCES public.rol(id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- Name: usuario_rol fk_usuariorol_refusuario; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usuario_rol
    ADD CONSTRAINT fk_usuariorol_refusuario FOREIGN KEY (usuario_id) REFERENCES public.usuario(id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- PostgreSQL database dump complete
--

