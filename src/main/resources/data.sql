INSERT INTO teacher (id, first_name, last_name)
VALUES (3, 'teacher1', 'teacher1');

INSERT INTO classroom (id, name, teacher_id)
VALUES (2, 'test', 3);

INSERT INTO student (id, first_name, last_name, classroom_id, teacher_id)
VALUES (1, 'test', 'test', 2, 3);


INSERT INTO teacher (id, first_name, last_name)
VALUES (6, 'teacher2', 'teacher2');

INSERT INTO classroom (id, name, teacher_id)
VALUES (5, 'class2', 6);

INSERT INTO student (id, first_name, last_name, classroom_id, teacher_id)
VALUES (4, 'student2', 'student2', 5, 6);