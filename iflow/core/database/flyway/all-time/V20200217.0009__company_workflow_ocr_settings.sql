

CREATE SEQUENCE company_workflowtype_items_ocr_preset_seq;

CREATE TABLE company_workflowtype_items_ocr_preset
(
    id bigint NOT NULL DEFAULT nextval('company_workflowtype_items_ocr_preset_seq'),
    identity varchar(45) DEFAULT NULL,
    company_id bigint NOT NULL,
    workflow_type_id bigint NOT NULL,
    preset_name character varying(200) NOT NULL,
    status smallint NOT NULL DEFAULT 1,
    version integer NOT NULL DEFAULT 1,
    created_at timestamp without time zone NOT NULL default (now() at time zone 'utc'),
    updated_at timestamp without time zone NOT NULL default (now() at time zone 'utc'),
    CONSTRAINT company_workflowtype_items_ocr_preset_pkey PRIMARY KEY (id)
        USING INDEX TABLESPACE iflow_tablespace,
    CONSTRAINT "FK_COMPANY_WORKFLOWTYPE_ITEMS_OCR_PRESET_WORKFLOWTYPE" FOREIGN KEY (workflow_type_id)
        REFERENCES public.workflow_type (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    CONSTRAINT "FK_COMPANY_WORKFLOWTYPE_ITEMS_OCR_PRESET_COMPANY" FOREIGN KEY (company_id)
        REFERENCES public.companies (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
        NOT VALID,
    CONSTRAINT "UQ_COMPANY_WORKFLOWTYPE_ITEMS_OCR_PRESET_NAME" UNIQUE (company_id, preset_name)
);

ALTER SEQUENCE company_workflowtype_items_ocr_preset_seq OWNED BY company_workflowtype_items_ocr_preset.id;


CREATE SEQUENCE company_workflowtype_items_ocr_preset_items_seq;

CREATE TABLE company_workflowtype_items_ocr_preset_items
(
    id bigint NOT NULL DEFAULT nextval('company_workflowtype_items_ocr_preset_items_seq'),
    preset_id bigint NOT NULL,
    property_name character varying(200) NOT NULL,
    value character varying(4000),
    ocr_type smallint NOT NULL DEFAULT 1,
    status smallint NOT NULL DEFAULT 1,
    version integer NOT NULL DEFAULT 1,
    created_at timestamp without time zone NOT NULL default (now() at time zone 'utc'),
    CONSTRAINT company_workflowtype_items_ocr_preset_items_pkey PRIMARY KEY (id)
        USING INDEX TABLESPACE iflow_tablespace,
    CONSTRAINT "FK_COMPANY_WORKFLOWTYPE_ITEMS_OCR_PRESET_ITEMS_PRESET" FOREIGN KEY (preset_id)
        REFERENCES public.company_workflowtype_items_ocr_preset (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
        NOT VALID
);

ALTER SEQUENCE company_workflowtype_items_ocr_preset_items_seq OWNED BY company_workflowtype_items_ocr_preset_items.id;



