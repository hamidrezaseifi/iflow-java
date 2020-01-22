


CREATE SEQUENCE companies_id_seq;
  
CREATE TABLE companies (
  id bigint NOT NULL PRIMARY KEY DEFAULT nextval('companies_id_seq'),
  identity varchar(45) DEFAULT NULL,
  company_name varchar(45) NOT NULL,
  status smallint NOT NULL DEFAULT 1,
  version integer NOT NULL DEFAULT 1,
  created_at timestamp without time zone NOT NULL default (now() at time zone 'utc'),
  updated_at timestamp without time zone NOT NULL default (now() at time zone 'utc')
);
ALTER SEQUENCE companies_id_seq OWNED BY companies.id;

CREATE SEQUENCE departments_id_seq;

CREATE TABLE departments (
  id bigint NOT NULL PRIMARY KEY DEFAULT nextval('departments_id_seq'),
  identity varchar(45) DEFAULT NULL,
  company_id bigint NOT NULL DEFAULT 1,
  title varchar(200) NOT NULL,
  status smallint NOT NULL DEFAULT 1,
  version integer NOT NULL DEFAULT 1,
  created_at timestamp without time zone NOT NULL default (now() at time zone 'utc'),
  updated_at timestamp without time zone NOT NULL default (now() at time zone 'utc'),
  
  CONSTRAINT FK_DEPARTMENTS_COMPANY FOREIGN KEY (company_id) REFERENCES companies (id) ON DELETE CASCADE ON UPDATE CASCADE
);
ALTER SEQUENCE departments_id_seq OWNED BY departments.id;


CREATE SEQUENCE departments_group_id_seq;
 
CREATE TABLE departments_group (
  id bigint NOT NULL PRIMARY KEY DEFAULT nextval('departments_group_id_seq'),
  identity varchar(45) DEFAULT NULL,
  department_id bigint NOT NULL,
  title varchar(200) NOT NULL,
  status smallint NOT NULL DEFAULT 1,
  version integer NOT NULL DEFAULT 1,
  created_at timestamp without time zone NOT NULL default (now() at time zone 'utc'),
  updated_at timestamp without time zone NOT NULL default (now() at time zone 'utc'),
  
  CONSTRAINT FK_DEPARTMENTGROUP_DEPARTMENT FOREIGN KEY (department_id) REFERENCES departments (id) ON DELETE CASCADE ON UPDATE CASCADE
);
ALTER SEQUENCE departments_group_id_seq OWNED BY departments_group.id;


CREATE SEQUENCE iflow_roles_id_seq;
 
CREATE TABLE iflow_roles (
  id bigint NOT NULL PRIMARY KEY DEFAULT nextval('iflow_roles_id_seq'),
  title varchar(200) NOT NULL,
  status smallint NOT NULL DEFAULT 1,
  version integer NOT NULL DEFAULT 1,
  created_at timestamp without time zone NOT NULL default (now() at time zone 'utc'),
  updated_at timestamp without time zone NOT NULL default (now() at time zone 'utc')
) ;
ALTER SEQUENCE iflow_roles_id_seq OWNED BY iflow_roles.id;
 

CREATE SEQUENCE users_id_seq;

CREATE TABLE users (
  id bigint NOT NULL PRIMARY KEY DEFAULT nextval('users_id_seq'),
  identity varchar(45) DEFAULT NULL UNIQUE,
  company_id bigint NOT NULL DEFAULT 1,
  email varchar(255)  NOT NULL UNIQUE,
  birthdate date DEFAULT NULL,
  password varchar(255)  NOT NULL DEFAULT '-',
  firstname varchar(45)  DEFAULT NULL,
  lastname varchar(45)  DEFAULT NULL,
  permission smallint NOT NULL DEFAULT 1,
  status smallint NOT NULL DEFAULT 1,
  version integer NOT NULL DEFAULT 1,
  created_at timestamp without time zone NOT NULL default (now() at time zone 'utc'),
  updated_at timestamp without time zone NOT NULL default (now() at time zone 'utc'),
  
  CONSTRAINT FK_USERS_COMPANIES FOREIGN KEY (company_id) REFERENCES companies (id) ON DELETE CASCADE ON UPDATE CASCADE
) ;
ALTER SEQUENCE users_id_seq OWNED BY users.id;

 
CREATE SEQUENCE user_group_id_seq;
 
CREATE TABLE user_group (
  id bigint NOT NULL PRIMARY KEY DEFAULT nextval('user_group_id_seq'),
  identity varchar(45) DEFAULT NULL,
  title varchar(200) NOT NULL,
  company_id bigint NOT NULL DEFAULT 1,
  status smallint NOT NULL DEFAULT 1,
  version integer NOT NULL DEFAULT 1,
  created_at timestamp without time zone NOT NULL default (now() at time zone 'utc'),
  updated_at timestamp without time zone NOT NULL default (now() at time zone 'utc'),
  
  CONSTRAINT FK_USERGROUP_COMPANY FOREIGN KEY (company_id) REFERENCES companies (id) ON DELETE CASCADE ON UPDATE CASCADE
) ;
ALTER SEQUENCE user_group_id_seq OWNED BY user_group.id;


CREATE TABLE user_deputy (
  user_id bigint NOT NULL,
  deputy_id bigint NOT NULL,
  created_at timestamp without time zone NOT NULL default (now() at time zone 'utc'),
  PRIMARY KEY (user_id,deputy_id),
  CONSTRAINT FK_USERDEPUTY_DEPUTY FOREIGN KEY (deputy_id) REFERENCES users (id),
  CONSTRAINT FK_USERDEPUTY_USER FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE ON UPDATE CASCADE
) ;


CREATE SEQUENCE user_department_id_seq;


CREATE TABLE user_departments (
  id bigint NOT NULL PRIMARY KEY DEFAULT nextval('user_department_id_seq'),
  user_id bigint NOT NULL,
  department_id bigint NOT NULL,
  member_type int NOT NULL default 5,
  created_at timestamp without time zone NOT NULL default (now() at time zone 'utc'),
  CONSTRAINT FK_USERDEPARTMENTS_DEPARTMENTS FOREIGN KEY (department_id) REFERENCES departments (id),
  CONSTRAINT FK_USERDEPARTMENTS_USERS FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE ON UPDATE CASCADE
) ;
ALTER SEQUENCE user_department_id_seq OWNED BY user_departments.id;


CREATE SEQUENCE user_department_groups_id_seq;

CREATE TABLE user_department_groups (
  id bigint NOT NULL PRIMARY KEY DEFAULT nextval('user_department_groups_id_seq'),
  user_id bigint NOT NULL,
  department_group_id bigint NOT NULL,
  member_type int NOT NULL default 5,
  created_at timestamp without time zone NOT NULL default (now() at time zone 'utc'),
  CONSTRAINT FK_USERDEPARTMENTGROUPS_D FOREIGN KEY (department_group_id) REFERENCES departments_group (id),
  CONSTRAINT FK_USERDEPARTMENTGROUPS_USERS FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE ON UPDATE CASCADE
) ;
ALTER SEQUENCE user_department_groups_id_seq OWNED BY user_department_groups.id;


CREATE TABLE user_usergroup (
  user_id bigint NOT NULL,
  user_group bigint NOT NULL,
  created_at timestamp without time zone NOT NULL default (now() at time zone 'utc'),
  PRIMARY KEY (user_id,user_group),
  CONSTRAINT FK_USERGROUPUSER_GROUP FOREIGN KEY (user_group) REFERENCES user_group (id),
  CONSTRAINT FK_USERGROUPUSER_USER FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE ON UPDATE CASCADE
) ;


CREATE TABLE user_roles (
  user_id bigint NOT NULL,
  role bigint NOT NULL,
  created_at timestamp without time zone NOT NULL default (now() at time zone 'utc'),
  PRIMARY KEY (user_id,role),
  CONSTRAINT FK_USERROLES_ROLE FOREIGN KEY (role) REFERENCES iflow_roles (id) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT FK_USERROLES_USERS FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE ON UPDATE CASCADE
) ;

CREATE SEQUENCE workflow_type_id_seq;

CREATE TABLE workflow_type (
  id bigint NOT NULL PRIMARY KEY DEFAULT nextval('workflow_type_id_seq'),
  identity varchar(45) DEFAULT NULL,
  title varchar(200) NOT NULL,
  assign_type SMALLINT NOT NULL DEFAULT 1,
  send_to_controller SMALLINT NOT NULL DEFAULT 1,
  increase_step_automatic SMALLINT DEFAULT '0',
  allow_assign SMALLINT DEFAULT '0',
  commecnts text,
  status smallint NOT NULL DEFAULT 1,
  version integer NOT NULL DEFAULT 1,
  created_at timestamp without time zone NOT NULL default (now() at time zone 'utc'),
  updated_at timestamp without time zone NOT NULL default (now() at time zone 'utc')
);
ALTER SEQUENCE workflow_type_id_seq OWNED BY workflow_type.id;


CREATE SEQUENCE workflow_type_step_id_seq;
 
CREATE TABLE workflow_type_step (
  id bigint NOT NULL PRIMARY KEY DEFAULT nextval('workflow_type_step_id_seq'),
  identity varchar(45) DEFAULT NULL,
  workflow_type_id bigint NOT NULL,
  title varchar(200) NOT NULL,
  step_index smallint NOT NULL DEFAULT 0,
  view_name varchar(150) NOT NULL DEFAULT '-',
  expire_days smallint NOT NULL,
  commecnts text,
  status smallint NOT NULL DEFAULT 1,
  version integer NOT NULL DEFAULT 1,
  created_at timestamp without time zone NOT NULL default (now() at time zone 'utc'),
  updated_at timestamp without time zone NOT NULL default (now() at time zone 'utc'),
  
  CONSTRAINT FK_WORKFLOWTYPESTEP_WORKFLOWTYPE FOREIGN KEY (workflow_type_id) REFERENCES workflow_type (id) ON DELETE CASCADE ON UPDATE CASCADE
);
ALTER SEQUENCE workflow_type_step_id_seq OWNED BY workflow_type_step.id;


CREATE SEQUENCE workflow_id_seq;
 
CREATE TABLE workflow (
  id bigint NOT NULL PRIMARY KEY DEFAULT nextval('workflow_id_seq'),
  company_id bigint NOT NULL,
  identity varchar(45) DEFAULT NULL,
  workflow_type_id bigint NOT NULL,
  current_step bigint NOT NULL,
  status bigint NOT NULL,
  comments text,
  controller bigint NOT NULL,
  created_by bigint DEFAULT NULL,
  version integer NOT NULL DEFAULT 1,
  created_at timestamp without time zone NOT NULL default (now() at time zone 'utc'),
  updated_at timestamp without time zone NOT NULL default (now() at time zone 'utc'),
  
  CONSTRAINT FK_WORKFLOW_COMPANY FOREIGN KEY (company_id) REFERENCES companies (id) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT FK_WORKFLOW_USERS FOREIGN KEY (created_by) REFERENCES users (id) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT FK_WORKFLOW_WORKFLOWTYPE FOREIGN KEY (workflow_type_id) REFERENCES workflow_type (id) ON UPDATE CASCADE,
  CONSTRAINT FK_WORKFLOW_WORKFLOWTYPESTEP FOREIGN KEY (current_step) REFERENCES workflow_type_step (id) ON UPDATE CASCADE
);
ALTER SEQUENCE workflow_id_seq OWNED BY workflow.id;


CREATE SEQUENCE workflow_actions_id_seq;
 
CREATE TABLE workflow_actions (
  id bigint NOT NULL PRIMARY KEY DEFAULT nextval('workflow_actions_id_seq'),
  workflow_id bigint NOT NULL,
  assign_to bigint NOT NULL DEFAULT '0',
  current_step_id bigint NOT NULL DEFAULT '0',
  comments varchar(45) DEFAULT NULL,
  status bigint DEFAULT 1,
  created_at timestamp without time zone NOT NULL default (now() at time zone 'utc'),
  updated_at timestamp without time zone NOT NULL default (now() at time zone 'utc'),
  
  CONSTRAINT FK_WORKFLOWACTION_WORKFLOW FOREIGN KEY (workflow_id) REFERENCES workflow (id) ON UPDATE CASCADE
);
ALTER SEQUENCE workflow_actions_id_seq OWNED BY workflow_actions.id;



CREATE SEQUENCE workflow_files_id_seq;
 
CREATE TABLE workflow_files (
  id bigint NOT NULL PRIMARY KEY DEFAULT nextval('workflow_files_id_seq'),
  identity varchar(45) DEFAULT NULL,
  workflow_id bigint NOT NULL,
  title varchar(200) NOT NULL,
  extention varchar(10) NOT NULL,
  active_filepath varchar(500) NOT NULL,
  comments text,
  active_version integer NOT NULL DEFAULT 1,
  status smallint NOT NULL DEFAULT 1,
  created_by bigint DEFAULT NULL,
  created_at timestamp without time zone NOT NULL default (now() at time zone 'utc'),
  updated_at timestamp without time zone NOT NULL default (now() at time zone 'utc'),
   
  CONSTRAINT FK_WORKFLOWFILE_USERS FOREIGN KEY (created_by) REFERENCES users (id) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT FK_WORKFLOWFILE_WORKFLOW FOREIGN KEY (workflow_id) REFERENCES workflow (id) ON UPDATE CASCADE
);
ALTER SEQUENCE workflow_files_id_seq OWNED BY workflow_files.id;

 
 
CREATE SEQUENCE workflow_files_versions_id_seq;

CREATE TABLE workflow_files_versions (
  id bigint NOT NULL PRIMARY KEY DEFAULT nextval('workflow_files_versions_id_seq'),
  workflow_file_id bigint NOT NULL,
  filepath varchar(500) NOT NULL,
  comments text,
  file_version integer NOT NULL DEFAULT 1,
  status smallint NOT NULL DEFAULT 1,
  created_by bigint DEFAULT NULL,
  created_at timestamp without time zone NOT NULL default (now() at time zone 'utc'),
  updated_at timestamp without time zone NOT NULL default (now() at time zone 'utc'),
  CONSTRAINT FK_WORKFLOWFILEVERSION_WORKFLOWFILE FOREIGN KEY (workflow_file_id) REFERENCES workflow_files (id) ON DELETE CASCADE ON UPDATE CASCADE
) ;
ALTER SEQUENCE workflow_files_versions_id_seq OWNED BY workflow_files_versions.id;

CREATE TABLE company_workflow_type (
  company_id bigint NOT NULL,
  workflow_type_id bigint NOT NULL,
  created_at timestamp without time zone NOT NULL default (now() at time zone 'utc'),
  PRIMARY KEY (company_id,workflow_type_id),
  CONSTRAINT FK_COMPANYWORKFLOWTYPE_COMPANY FOREIGN KEY (company_id) REFERENCES companies (id) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT FK_COMPANYWORKFLOWTYPE_WORKFLOWTYPE FOREIGN KEY (workflow_type_id) REFERENCES workflow_type (id) ON DELETE CASCADE ON UPDATE CASCADE
) ;

