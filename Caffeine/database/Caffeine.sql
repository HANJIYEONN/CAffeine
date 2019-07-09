CREATE TABLE CAF_ACCOUNT (
    ID          VARCHAR2(20)
    ,PW         VARCHAR2(20)
    ,NAME       VARCHAR2(20)
    ,NICKNAME   VARCHAR2(20)
    ,EMAIL      VARCHAR2(50)    PRIMARY KEY
);

SELECT  *
FROM    CAF_ACCOUNT;


INSERT INTO CAF_ACCOUNT
VALUES ('hanji', '0403', 'วัม๖ฟฌ', 'HanjiHanji', 'hanji0403@naver.com');

COMMIT;