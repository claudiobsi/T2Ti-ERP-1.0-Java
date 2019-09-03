CREATE  VIEW `view_60d` AS (
SELECT  
	`vd`.`GTIN` AS `GTIN`, 
	`i`.`SERIE` AS `SERIE`, 
	`vc`.`DATA_VENDA` AS `DATA_EMISSAO`,
	`m`.`ID` AS `ID`, 
	`vd`.`ECF_ICMS_ST` AS `ECF_ICMS_ST`,
	SUM(`vd`.`QUANTIDADE`) AS `SOMA_QUANTIDADE`,
	SUM(`vd`.`VALOR_TOTAL`) AS `SOMA_ITEM`,
	SUM(`vd`.`BASE_ICMS`) AS `SOMA_BASE_ICMS`, 
	SUM(`vd`.`ICMS`) AS `SOMA_ICMS`
FROM 
	(((`ecf_venda_cabecalho` `vc`  JOIN `ecf_venda_detalhe` `vd`)  JOIN `ecf_impressora` `i`)  JOIN `ecf_movimento` `m`)
WHERE
	((`vc`.`ID_ECF_MOVIMENTO` = `m`.`ID`)
	AND (`m`.`ID_ECF_IMPRESSORA` = `i`.`ID`)
	AND (`vd`.`ID_ECF_VENDA_CABECALHO` = `vc`.`ID`)
	AND (`vd`.`CANCELADO` = 'N'))
GROUP BY
	`vd`.`GTIN`,
	`i`.`SERIE`,
	`vc`.`DATA_VENDA`,
	`m`.`ID`,
	`vd`.`ECF_ICMS_ST`
);

CREATE VIEW `view_60r` AS (
select
	`vd`.`GTIN` AS `GTIN`,
	`i`.`SERIE` AS `SERIE`,
	`vc`.`DATA_VENDA` AS `DATA_EMISSAO`,
	month(`vc`.`DATA_VENDA`) AS `MES_EMISSAO`,
	year(`vc`.`DATA_VENDA`) AS `ANO_EMISSAO`,
	`m`.`ID` AS `ID`,
	`vd`.`ECF_ICMS_ST` AS `ECF_ICMS_ST`,
	sum(`vd`.`QUANTIDADE`) AS `SOMA_QUANTIDADE`,
	sum(`vd`.`VALOR_TOTAL`) AS `SOMA_ITEM`,
	sum(`vd`.`BASE_ICMS`) AS `SOMA_BASE_ICMS`,
	sum(`vd`.`ICMS`) AS `SOMA_ICMS`
from 
	(((`ecf_venda_cabecalho` `vc`  join `ecf_venda_detalhe` `vd`)  join `ecf_impressora` `i`)  join `ecf_movimento` `m`)
where
	((`vc`.`ID_ECF_MOVIMENTO` = `m`.`ID`)
	and (`m`.`ID_ECF_IMPRESSORA` = `i`.`ID`)
	and (`vd`.`ID_ECF_VENDA_CABECALHO` = `vc`.`ID`))
group by
	month(`vc`.`DATA_VENDA`),
	year(`vc`.`DATA_VENDA`),
	`vd`.`GTIN`
);

CREATE VIEW `view_61r` AS (
select
	`p`.`GTIN` AS `GTIN`,
	`nf2c`.`DATA_EMISSAO` AS `DATA_EMISSAO`,
	month(`nf2c`.`DATA_EMISSAO`) AS `MES_EMISSAO`,
	year(`nf2c`.`DATA_EMISSAO`) AS `ANO_EMISSAO`,
	`nf2d`.`ECF_ICMS_ST` AS `ECF_ICMS_ST`,
	sum(`nf2d`.`QUANTIDADE`) AS `SOMA_QUANTIDADE`,
	sum(`nf2d`.`VALOR_TOTAL`) AS `SOMA_ITEM`,
	sum(`nf2d`.`BASE_ICMS`) AS `SOMA_BASE_ICMS`
from
	((`nota_fiscal_cabecalho` `nf2c`  join `nota_fiscal_detalhe` `nf2d`)  join `produto` `p`)
where
	((`nf2d`.`ID_PRODUTO` = `p`.`ID`)
	and (`nf2d`.`ID_NF_CABECALHO` = `nf2c`.`ID`))
group by
	month(`nf2c`.`DATA_EMISSAO`),
	year(`nf2c`.`DATA_EMISSAO`),
	`p`.`GTIN`,
	`p`.`ECF_ICMS_ST`
);

CREATE VIEW `view_r04` AS (
select
	`vc`.`ID` AS `VCID`,
	`vc`.`ID_ECF_MOVIMENTO` AS `ID_ECF_MOVIMENTO`,
	`vc`.`SERIE_ECF` AS `SERIE_ECF`,
	`vc`.`CCF` AS `CCF`,
	`vc`.`COO` AS `COO`,
	`vc`.`DATA_VENDA` AS `DATA_VENDA`,
	`vc`.`VALOR_VENDA` AS `VALOR_VENDA`,
	`vc`.`HASH_TRIPA` AS `HASH_TRIPA`,
	`vc`.`HASH_INCREMENTO` AS `HASH_INCREMENTO`,
	`vc`.`DESCONTO` AS `DESCONTO`,
	`vc`.`ACRESCIMO` AS `ACRESCIMO`,
	`vc`.`VALOR_FINAL` AS `VALOR_FINAL`,
	`vc`.`STATUS_VENDA` AS `STATUS_VENDA`,
	`vc`.`CUPOM_CANCELADO` AS `CUPOM_CANCELADO`,
	`vc`.`NOME_CLIENTE` AS `NOME_CLIENTE`,
	`vc`.`PIS` AS `PIS`,
	`vc`.`COFINS` AS `COFINS`,
	`vc`.`CPF_CNPJ_CLIENTE` AS `CPF_CNPJ_CLIENTE`,
	`m`.`ID` AS `MID`,
	`m`.`ID_ECF_IMPRESSORA` AS `ID_ECF_IMPRESSORA`,
	`m`.`ID_ECF_OPERADOR` AS `ID_ECF_OPERADOR`
from
	(`ecf_venda_cabecalho` `vc`  join `ecf_movimento` `m`)
where
	(`vc`.`ID_ECF_MOVIMENTO` = `m`.`ID`)
);


CREATE VIEW `view_r05` AS (
select
	`vc`.`ID` AS `VCID`,
	`v`.`ID` AS `VID`,
	`v`.`ITEM` AS `ITEM`,
	`v`.`SERIE_ECF` AS `SERIE_ECF`,
	`v`.`GTIN` AS `GTIN`,
	`v`.`CCF` AS `CCF`,
	`v`.`COO` AS `COO`,
	`p`.`DESCRICAO_PDV` AS `DESCRICAO_PDV`,
	`v`.`QUANTIDADE` AS `QUANTIDADE`,
	`v`.`CST` AS `CST`,
	`v`.`PIS` AS `PIS`,
	`v`.`COFINS` AS `COFINS`,
	`v`.`HASH_TRIPA` AS `HASH_TRIPA`,
	`v`.`HASH_INCREMENTO` AS `HASH_INCREMENTO`,
	`u`.`NOME` AS `SIGLA_UNIDADE`,
	`v`.`VALOR_UNITARIO` AS `VALOR_UNITARIO`,
	`v`.`DESCONTO` AS `DESCONTO`,
	`v`.`ACRESCIMO` AS `ACRESCIMO`,
	`v`.`CFOP` AS `CFOP`,
	`v`.`TAXA_ICMS` AS `TAXA_ICMS`,
	`v`.`ID_ECF_PRODUTO` AS `ID_ECF_PRODUTO`,
	`v`.`TOTAL_ITEM` AS `TOTAL_ITEM`,
	`v`.`TOTALIZADOR_PARCIAL` AS `TOTALIZADOR_PARCIAL`,
	`v`.`CANCELADO` AS `CANCELADO`,
	`p`.`IAT` AS `IAT`,
	`p`.`IPPT` AS `IPPT`,
	`p`.`ID_UNIDADE_PRODUTO` AS `ID_UNIDADE`
from
	(((`ecf_venda_cabecalho` `vc`  join `ecf_venda_detalhe` `v`)  join `produto` `p`)  join `unidade_produto` `u`)
where
	((`vc`.`ID` = `v`.`ID_ECF_VENDA_CABECALHO`)
	and (`v`.`ID_ECF_PRODUTO` = `p`.`ID`)
	and (`p`.`ID_UNIDADE_PRODUTO` = `u`.`ID`))
);