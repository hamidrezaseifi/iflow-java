
DROP TABLE IF EXISTS company_workflowtype_controller;

CREATE TABLE company_workflowtype_controller (
  company_id bigint NOT NULL,
  workflow_type_id bigint NOT NULL,
  user_id bigint NOT NULL,
  priority smallint NOT NULL,
  created_at timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
  PRIMARY KEY (company_id,workflow_type_id,user_id,priority),
  CONSTRAINT FK_COMPANY_WORKFLOWTYPE_CONTROLLER_COMPANY FOREIGN KEY (company_id) REFERENCES companies (id) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT FK_COMPANY_WORKFLOWTYPE_CONTROLLER_USER FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT FK_COMPANY_WORKFLOWTYPE_CONTROLLER_WORKFLOWTYPE FOREIGN KEY (workflow_type_id) REFERENCES workflow_type (id) ON DELETE CASCADE ON UPDATE CASCADE
) ;

INSERT INTO company_workflowtype_controller (company_id, workflow_type_id, user_id, priority) VALUES (1, 1, 1, 1);
INSERT INTO company_workflowtype_controller (company_id, workflow_type_id, user_id, priority) VALUES (1, 2, 1, 1);
INSERT INTO company_workflowtype_controller (company_id, workflow_type_id, user_id, priority) VALUES (1, 3, 1, 1);
INSERT INTO company_workflowtype_controller (company_id, workflow_type_id, user_id, priority) VALUES (1, 1, 2, 2);
INSERT INTO company_workflowtype_controller (company_id, workflow_type_id, user_id, priority) VALUES (1, 3, 2, 2);


