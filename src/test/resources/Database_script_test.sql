DROP ALL OBJECTS;
create type roles AS ENUM ('admin', 'moderator', 'teacher', 'student');
create type types AS ENUM ('checkbox', 'radiobutton');

CREATE TABLE IF NOT EXISTS subjects
(
    id   SERIAL PRIMARY KEY,
    name varchar UNIQUE
);

CREATE TABLE IF NOT EXISTS groups
(
    id         SERIAL PRIMARY KEY,
    name       varchar UNIQUE,
    created_at timestamp
);

CREATE TABLE IF NOT EXISTS users
(
    id          SERIAL PRIMARY KEY,
    role_type   roles,
    email       varchar,
    hash        varchar,
    salt        varchar,
    first_name  varchar,
    last_name   varchar,
    middle_name varchar,
    birth_date  Date,
    work_title  varchar,
    created_at  timestamp,
    avatar      varchar,
    group_id    int REFERENCES groups (id)
);



CREATE TABLE IF NOT EXISTS tests
(
    id          SERIAL PRIMARY KEY,
    title       varchar,
    description varchar,
    subject_id  int REFERENCES subjects (id),
    is_random   boolean,
    created_at  timestamp,
    max_points  int,
    creator_id  int
);

CREATE TABLE IF NOT EXISTS groups_tests
(
    test_id      int REFERENCES tests (id),
    group_id     int REFERENCES groups (id),
    is_necessary boolean,
    max_attempts int DEFAULT 3,
    deadline     timestamp,
    time_limit   int,
    PRIMARY KEY (test_id, group_id)
);

CREATE TABLE IF NOT EXISTS questions
(
    id            SERIAL PRIMARY KEY,
    question_type types,
    title         varchar,
    image         varchar,
    question_text varchar,
    test_id       int REFERENCES tests (id)
);

CREATE TABLE IF NOT EXISTS answers
(
    id          SERIAL PRIMARY KEY,
    image       varchar,
    answer_text varchar,
    question_id int REFERENCES questions (id),
    is_correct  boolean,
    points      int
);

CREATE TABLE IF NOT EXISTS attempts
(
    id           SERIAL PRIMARY KEY,
    test_id      int REFERENCES tests (id),
    user_id      int REFERENCES users (id),
    score        int,
    passing_date timestamp
);
