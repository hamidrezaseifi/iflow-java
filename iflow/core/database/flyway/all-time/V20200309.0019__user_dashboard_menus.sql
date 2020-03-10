

CREATE SEQUENCE user_dashboard_menus_seq INCREMENT 10 START 1;

CREATE TABLE user_dashboard_menus
(
    id bigint NOT NULL DEFAULT nextval('user_dashboard_menus_seq'),
    user_id bigint NOT NULL,
    app_id varchar(45) DEFAULT NULL,
    menu_id varchar(45) DEFAULT NULL,
    row_index int NOT NULL,
    column_index int NOT NULL,
    status smallint NOT NULL DEFAULT 1,
    version integer NOT NULL DEFAULT 1,
    created_at timestamp without time zone NOT NULL default (now() at time zone 'utc'),
    CONSTRAINT user_dashboard_menus_pkey PRIMARY KEY (id),
    CONSTRAINT "FK_USER_DASHBOARD_MENUS_USERS" FOREIGN KEY (user_id)
        REFERENCES users (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
);

ALTER SEQUENCE user_dashboard_menus_seq OWNED BY user_dashboard_menus.id;

