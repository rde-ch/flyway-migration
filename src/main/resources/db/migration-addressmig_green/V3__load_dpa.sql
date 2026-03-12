COPY addressmig_green.dpa
    FROM '/data/ID28_DPA_Records.csv'
    WITH (
    FORMAT csv,
    Header true,
    DELIMITER ','
    );