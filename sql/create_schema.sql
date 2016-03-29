create sequence "twitter_message_seq"
start with 1;

create table "twitter_message" (
"id" int primary key,
"user" text,
"text" text,
"created_date" timestamp
);
