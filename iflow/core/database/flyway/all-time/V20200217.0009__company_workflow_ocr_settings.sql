
CREATE SEQUENCE company_workflowtype_items_ocr_settings_seq;

CREATE TABLE company_workflowtype_items_ocr_settings
(
    id bigint NOT NULL DEFAULT nextval('company_workflowtype_items_ocr_settings_seq'::regclass),
    company_id bigint NOT NULL,
    workflow_type_id bigint NOT NULL,
    property_name character varying(200) COLLATE pg_catalog."default" NOT NULL,
    value character varying(4000) COLLATE pg_catalog."default",
    status smallint NOT NULL DEFAULT 1,
    version integer NOT NULL DEFAULT 1,
    created_at timestamp without time zone NOT NULL default (now() at time zone 'utc'),
    CONSTRAINT company_workflowtype_items_ocr_settings_pkey PRIMARY KEY (id)
        USING INDEX TABLESPACE iflow_tablespace,
    CONSTRAINT "FK_COMPANY_WORKFLOWTYPE_ITEMS_OCR_SETTINGS_COMPANY" FOREIGN KEY (company_id)
        REFERENCES public.companies (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    CONSTRAINT "FK_COMPANY_WORKFLOWTYPE_ITEMS_OCR_SETTINGS_WORKFLOWTYPE" FOREIGN KEY (workflow_type_id)
        REFERENCES public.workflow_type (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
) ;

ALTER SEQUENCE company_workflowtype_items_ocr_settings_seq OWNED BY company_workflowtype_items_ocr_settings.id;



