DELIMITER $$

CREATE
    /*[DEFINER = { user | CURRENT_USER }]*/
    TRIGGER `t2tipafecfjava`.`HashDavCabecalho` BEFORE UPDATE
    ON `t2tipafecfjava`.`dav_cabecalho`
    FOR EACH ROW BEGIN
	SET NEW.HASH_INCREMENTO = NEW.HASH_INCREMENTO + 1;
    END$$

DELIMITER ;

DELIMITER $$

CREATE
    /*[DEFINER = { user | CURRENT_USER }]*/
    TRIGGER `t2tipafecfjava`.`HashDavDetalhe` BEFORE UPDATE
    ON `t2tipafecfjava`.`dav_detalhe`
    FOR EACH ROW BEGIN
	SET NEW.HASH_INCREMENTO = NEW.HASH_INCREMENTO + 1;
    END$$

DELIMITER ;


DELIMITER $$

CREATE
    /*[DEFINER = { user | CURRENT_USER }]*/
    TRIGGER `t2tipafecfjava`.`HashProduto` BEFORE UPDATE
    ON `t2tipafecfjava`.`produto`
    FOR EACH ROW BEGIN
	SET NEW.HASH_INCREMENTO = NEW.HASH_INCREMENTO + 1;
    END$$

DELIMITER ;

DELIMITER $$

CREATE
    /*[DEFINER = { user | CURRENT_USER }]*/
    TRIGGER `t2tipafecfjava`.`HashR01` BEFORE UPDATE
    ON `t2tipafecfjava`.`r01`
    FOR EACH ROW BEGIN
	SET NEW.HASH_INCREMENTO = NEW.HASH_INCREMENTO + 1;
    END$$

DELIMITER ;

DELIMITER $$

CREATE
    /*[DEFINER = { user | CURRENT_USER }]*/
    TRIGGER `t2tipafecfjava`.`HashR02` BEFORE UPDATE
    ON `t2tipafecfjava`.`r02`
    FOR EACH ROW BEGIN
	SET NEW.HASH_INCREMENTO = NEW.HASH_INCREMENTO + 1;
    END$$

DELIMITER ;

DELIMITER $$

CREATE
    /*[DEFINER = { user | CURRENT_USER }]*/
    TRIGGER `t2tipafecfjava`.`HashR03` BEFORE UPDATE
    ON `t2tipafecfjava`.`r03`
    FOR EACH ROW BEGIN
	SET NEW.HASH_INCREMENTO = NEW.HASH_INCREMENTO + 1;
    END$$

DELIMITER ;

DELIMITER $$

CREATE
    /*[DEFINER = { user | CURRENT_USER }]*/
    TRIGGER `t2tipafecfjava`.`HashR06` BEFORE UPDATE
    ON `t2tipafecfjava`.`r06`
    FOR EACH ROW BEGIN
	SET NEW.HASH_INCREMENTO = NEW.HASH_INCREMENTO + 1;
    END$$

DELIMITER ;

DELIMITER $$

CREATE
    /*[DEFINER = { user | CURRENT_USER }]*/
    TRIGGER `t2tipafecfjava`.`HashTotalTipoPgto` BEFORE UPDATE
    ON `t2tipafecfjava`.`ecf_total_tipo_pgto`
    FOR EACH ROW BEGIN
	SET NEW.HASH_INCREMENTO = NEW.HASH_INCREMENTO + 1;
    END$$

DELIMITER ;

DELIMITER $$

CREATE
    /*[DEFINER = { user | CURRENT_USER }]*/
    TRIGGER `t2tipafecfjava`.`HashVendaCabecalho` BEFORE UPDATE
    ON `t2tipafecfjava`.`ecf_venda_cabecalho`
    FOR EACH ROW BEGIN
	SET NEW.HASH_INCREMENTO = NEW.HASH_INCREMENTO + 1;
    END$$

DELIMITER ;

DELIMITER $$

CREATE
    /*[DEFINER = { user | CURRENT_USER }]*/
    TRIGGER `t2tipafecfjava`.`HashVendaDetalhe` BEFORE UPDATE
    ON `t2tipafecfjava`.`ecf_venda_detalhe`
    FOR EACH ROW BEGIN
	SET NEW.HASH_INCREMENTO = NEW.HASH_INCREMENTO + 1;
    END$$

DELIMITER ;

DELIMITER $$

CREATE
    /*[DEFINER = { user | CURRENT_USER }]*/
    TRIGGER `t2tipafecfjava`.`HashEstoque` BEFORE UPDATE
    ON `t2tipafecfjava`.`ecf_estoque`
    FOR EACH ROW BEGIN
	SET NEW.HASH_INCREMENTO = NEW.HASH_INCREMENTO + 1;
    END$$

DELIMITER ;