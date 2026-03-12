
CREATE TABLE addressmig_green.dpa_staging(
 LIKE addressmig_green.dpa INCLUDING ALL
);

ALTER TABLE addressmig_green.dpa RENAME TO dpa_backup;
ALTER TABLE addressmig_green.dpa_staging RENAME TO dpa;