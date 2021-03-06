/*
SQLyog Ultimate v8.6 Beta2
MySQL - 5.1.49-community : Database - t2tipafecfjava
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`t2tipafecfjava` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `t2tipafecfjava`;

/*Table structure for table `banco` */

DROP TABLE IF EXISTS `banco`;

CREATE TABLE `banco` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `CODIGO` int(10) unsigned DEFAULT NULL,
  `NOME` varchar(100) DEFAULT NULL,
  `URL` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `banco` */

/*Table structure for table `cfop` */

DROP TABLE IF EXISTS `cfop`;

CREATE TABLE `cfop` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `CFOP` int(10) unsigned DEFAULT NULL,
  `DESCRICAO` text,
  `APLICACAO` text,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=542 DEFAULT CHARSET=latin1;

/*Data for the table `cfop` */

insert  into `cfop`(`ID`,`CFOP`,`DESCRICAO`,`APLICACAO`) values (1,1000,'ENTRADAS OU AQUISIÇÕES DE SERVIÇOS DO ESTADO','Classificam-se, neste grupo, as operações ou prestações em que o estabelecimento remetente esteja localizado na mesma unidade da Federação do destinatário'),(2,1100,'COMPRAS PARA INDUSTRIALIZAÇÃO, COMERCIALIZAÇÃO OU PRESTAÇÃO DE SERVIÇOS',''),(3,1101,'Compra para industrialização','Classificam-se neste código as compras de mercadorias a serem utilizadas em processo de industrialização. Também serão classificadas neste código as entradas de mercadorias em estabelecimento industrial de cooperativa recebidas de seus cooperados ou de estabelecimento de outra cooperativa.'),(4,1102,'Compra para comercialização','Classificam-se neste código as compras de mercadorias a serem comercializadas. Também serão classificadas neste código as entradas de mercadorias em estabelecimento comercial de cooperativa recebidas de seus cooperados ou de estabelecimento de outra cooperativa.'),(5,1111,'Compra para industrialização de mercadoria recebida anteriormente em consignação industrial','Classificam-se neste código as compras efetivas de mercadorias a serem utilizadas em processo de industrialização, recebidas anteriormente a título de consignação industrial.'),(6,1113,'Compra para comercialização, de mercadoria recebida anteriormente em consignação mercantil','Classificam-se neste código as compras efetivas de mercadorias recebidas anteriormente a título de consignação mercantil.'),(7,1116,'Compra para industrialização originada de encomenda para recebimento futuro','Classificam-se neste código as compras de mercadorias a serem utilizadas em processo de industrialização, quando da entrada real da mercadoria, cuja aquisição tenha sido classificada no código 1.922 - Lançamento efetuado a título de simples faturamento decorrente de compra para recebimento futuro.'),(8,1117,'Compra para comercialização originada de encomenda para recebimento futuro','Classificam-se neste código as compras de mercadorias a serem comercializadas, quando da entrada real da mercadoria, cuja aquisição tenha sido classificada no código 1.922 - Lançamento efetuado a título de simples faturamento decorrente de compra para recebimento futuro.'),(9,1118,'Compra de mercadoria para comercialização pelo adquirente originário, entregue pelo vendedor remetente ao destinatário, em venda à ordem','Classificam-se neste código as compras de mercadorias já comercializadas, que, sem transitar pelo estabelecimento do adquirente originário, sejam entregues pelo vendedor remetente diretamente ao destinatário, em operação de venda à ordem, cuja venda seja classificada, pelo adquirente originário, no código 5.120 - Venda de mercadoria adquirida ou recebida de terceiros entregue ao destinatário pelo vendedor remetente, em venda à ordem.'),(10,1120,'Compra para industrialização, em venda à ordem, já recebida do vendedor remetente','Classificam-se neste código as compras de mercadorias a serem utilizadas em processo de industrialização, em vendas à ordem, já recebidas do vendedor remetente, por ordem do adquirente originário.'),(11,1121,'Compra para comercialização, em venda à ordem, já recebida do vendedor remetente','Classificam-se neste código as compras de mercadorias a serem comercializadas, em vendas à ordem, já recebidas do vendedor remetente por ordem do adquirente originário.'),(12,1122,'Compra para industrialização em que a mercadoria foi remetida pelo fornecedor ao industrializador sem transitar pelo estabelecimento adquirente','Classificam-se neste código as compras de mercadorias a serem utilizadas em processo de industrialização, remetidas pelo fornecedor para o industrializador sem que a mercadoria tenha transitado pelo estabelecimento do adquirente.'),(13,1124,'Industrialização efetuada por outra empresa','Classificam-se neste código as entradas de mercadorias industrializadas por terceiros, compreendendo os valores referentes aos serviços prestados e os das mercadorias de propriedade do industrializador empregadas no processo industrial. Quando a industrialização efetuada se referir a bens do ativo imobilizado ou de mercadorias para uso ou consumo do estabelecimento encomendante, a entrada deverá ser classificada nos códigos 1.551 - Compra de bem para o ativo imobilizado ou 1.556 - Compra de material para uso ou consumo.'),(14,1125,'Industrialização efetuada por outra empresa quando a mercadoria remetida para utilização no processo de industrialização não transitou pelo estabelecimento adquirente da mercadoria','Classificam-se neste código as entradas de mercadorias industrializadas por outras empresas, em que as mercadorias remetidas para utilização no processo de industrialização não transitaram pelo estabelecimento do adquirente das mercadorias, compreendendo os valores referentes aos serviços prestados e os das mercadorias de propriedade do industrializador empregadas no processo industrial. Quando a industrialização efetuada se referir a bens do ativo imobilizado ou de mercadorias para uso ou consumo do estabelecimento encomendante, a entrada deverá ser classificada nos códigos 1.551 - Compra de bem para o ativo imobilizado ou 1.556 - Compra de material para uso ou consumo.'),(15,1126,'Compra para utilização na prestação de serviço','Classificam-se neste código as entradas de mercadorias a serem utilizadas nas prestações de serviços.'),(16,1150,'TRANSFERÊNCIAS PARA INDUSTRIALIZAÇÃO, COMERCIALIZAÇÃO OU PRESTAÇÃO DE SERVIÇOS',''),(17,1151,'Transferência para industrialização','Classificam-se neste código as entradas de mercadorias recebidas em transferência de outro estabelecimento da mesma empresa, para serem utilizadas em processo de industrialização.'),(18,1152,'Transferência para comercialização','Classificam-se neste código as entradas de mercadorias recebidas em transferência de outro estabelecimento da mesma empresa, para serem comercializadas.'),(19,1153,'Transferência de energia elétrica para distribuição','Classificam-se neste código as entradas de energia elétrica recebida em transferência de outro estabelecimento da mesma empresa, para distribuição.'),(20,1154,'Transferência para utilização na prestação de serviço','Classificam-se neste código as entradas de mercadorias recebidas em transferência de outro estabelecimento da mesma empresa, para serem utilizadas nas prestações de serviços.'),(21,1200,'DEVOLUÇÕES DE VENDAS DE PRODUÇÃO PRÓPRIA, DE TERCEIROS OU ANULAÇÕES DE VALORES',''),(22,1201,'Devolução de venda de produção do estabelecimento','Classificam-se neste código as devoluções de vendas de produtos industrializados pelo estabelecimento, cujas saídas tenham sido classificadas como Venda de produção do estabelecimento.'),(23,1202,'Devolução de venda de mercadoria adquirida ou recebida de terceiros','Classificam-se neste código as devoluções de vendas de mercadorias adquiridas ou recebidas de terceiros, que não tenham sido objeto de industrialização no estabelecimento, cujas saídas tenham sido classificadas como Venda de mercadoria adquirida ou recebida de terceiros.'),(24,1203,'Devolução de venda de produção do estabelecimento, destinada à Zona Franca de Manaus ou Áreas de Livre Comércio','Classificam-se neste código as devoluções de vendas de produtos industrializados pelo estabelecimento, cujas saídas foram classificadas no código 5.109 - Venda de produção do estabelecimento, destinada à Zona Franca de Manaus ou Áreas de Livre Comércio.'),(25,1204,'Devolução de venda de mercadoria adquirida ou recebida de terceiros, destinada à Zona Franca de Manaus ou Áreas de Livre Comércio','Classificam-se neste código as devoluções de vendas de mercadorias adquiridas ou recebidas de terceiros, cujas saídas foram classificadas no código 5.110 - Venda de mercadoria adquirida ou recebida de terceiros, destinada à Zona Franca de Manaus ou Áreas de Livre Comércio.'),(26,1205,'Anulação de valor relativo à prestação de serviço de comunicação','Classificam-se neste código as anulações correspondentes a valores faturados indevidamente, decorrentes de prestações de serviços de comunicação.'),(27,1206,'Anulação de valor relativo à prestação de serviço de transporte','Classificam-se neste código as anulações correspondentes a valores faturados indevidamente, decorrentes de prestações de serviços de transporte.'),(28,1207,'Anulação de valor relativo à venda de energia elétrica','Classificam-se neste código as anulações correspondentes a valores faturados indevidamente, decorrentes de venda de energia elétrica.'),(29,1208,'Devolução de produção do estabelecimento, remetida em transferência','Classificam-se neste código as devoluções de produtos industrializados pelo estabelecimento, transferidos para outros estabelecimentos da mesma empresa.'),(30,1209,'Devolução de mercadoria adquirida ou recebida de terceiros, remetida em transferência','Classificam-se neste código as devoluções de mercadorias adquiridas ou recebidas de terceiros, transferidas para outros estabelecimentos da mesma empresa.'),(31,1250,'COMPRAS DE ENERGIA ELÉTRICA',''),(32,1251,'Compra de energia elétrica para distribuição ou comercialização','Classificam-se neste código as compras de energia elétrica utilizada em sistema de distribuição ou comercialização. Também serão classificadas neste código as compras de energia elétrica por cooperativas para distribuição aos seus cooperados.'),(33,1252,'Compra de energia elétrica por estabelecimento industrial','Classificam-se neste código as compras de energia elétrica utilizada no processo de industrialização. Também serão classificadas neste código as compras de energia elétrica utilizada por estabelecimento industrial de cooperativa.'),(34,1253,'Compra de energia elétrica por estabelecimento comercial','Classificam-se neste código as compras de energia elétrica utilizada por estabelecimento comercial. Também serão classificadas neste código as compras de energia elétrica utilizada por estabelecimento comercial de cooperativa.'),(35,1254,'Compra de energia elétrica por estabelecimento prestador de serviço de transporte','Classificam-se neste código as compras de energia elétrica utilizada por estabelecimento prestador de serviços de transporte.'),(36,1255,'Compra de energia elétrica por estabelecimento prestador de serviço de comunicação','Classificam-se neste código as compras de energia elétrica utilizada por estabelecimento prestador de serviços de comunicação.'),(37,1256,'Compra de energia elétrica por estabelecimento de produtor rural','Classificam-se neste código as compras de energia elétrica utilizada por estabelecimento de produtor rural.'),(38,1257,'Compra de energia elétrica para consumo por demanda contratada','Classificam-se neste código as compras de energia elétrica para consumo por demanda contratada, que prevalecerá sobre os demais códigos deste subgrupo.'),(39,1300,'AQUISIÇÕES DE SERVIÇOS DE COMUNICAÇÃO',''),(40,1301,'Aquisição de serviço de comunicação para execução de serviço da mesma natureza','Classificam-se neste código as aquisições de serviços de comunicação utilizados nas prestações de serviços da mesma natureza.'),(41,1302,'Aquisição de serviço de comunicação por estabelecimento industrial','Classificam-se neste código as aquisições de serviços de comunicação utilizados por estabelecimento industrial. Também serão classificadas neste código as aquisições de serviços de comunicação utilizados por estabelecimento industrial de cooperativa.'),(42,1303,'Aquisição de serviço de comunicação por estabelecimento comercial','Classificam-se neste código as aquisições de serviços de comunicação utilizados por estabelecimento comercial. Também serão classificadas neste código as aquisições de serviços de comunicação utilizados por estabelecimento comercial de cooperativa.'),(43,1304,'Aquisição de serviço de comunicação por estabelecimento de prestador de serviço de transporte','Classificam-se neste código as aquisições de serviços de comunicação utilizados por estabelecimento prestador de serviço de transporte.'),(44,1305,'Aquisição de serviço de comunicação por estabelecimento de geradora ou de distribuidora de energia elétrica','Classificam-se neste código as aquisições de serviços de comunicação utilizados por estabelecimento de geradora ou de distribuidora de energia elétrica.'),(45,1306,'Aquisição de serviço de comunicação por estabelecimento de produtor rural','Classificam-se neste código as aquisições de serviços de comunicação utilizados por estabelecimento de produtor rural.'),(46,1350,'AQUISIÇÕES DE SERVIÇOS DE TRANSPORTE',''),(47,1351,'Aquisição de serviço de transporte para execução de serviço da mesma natureza','Classificam-se neste código as aquisições de serviços de transporte utilizados nas prestações de serviços da mesma natureza.'),(48,1352,'Aquisição de serviço de transporte por estabelecimento industrial','Classificam-se neste código as aquisições de serviços de transporte utilizados por estabelecimento industrial. Também serão classificadas neste código as aquisições de serviços de transporte utilizados por estabelecimento industrial de cooperativa.'),(49,1353,'Aquisição de serviço de transporte por estabelecimento comercial','Classificam-se neste código as aquisições de serviços de transporte utilizados por estabelecimento comercial. Também serão classificadas neste código as aquisições de serviços de transporte utilizados por estabelecimento comercial de cooperativa.'),(50,1354,'Aquisição de serviço de transporte por estabelecimento de prestador de serviço de comunicação','Classificam-se neste código as aquisições de serviços de transporte utilizados por estabelecimento prestador de serviços de comunicação.'),(51,1355,'Aquisição de serviço de transporte por estabelecimento de geradora ou de distribuidora de energia elétrica','Classificam-se neste código as aquisições de serviços de transporte utilizados por estabelecimento de geradora ou de distribuidora de energia elétrica.'),(52,1356,'Aquisição de serviço de transporte por estabelecimento de produtor rural','Classificam-se neste código as aquisições de serviços de transporte utilizados por estabelecimento de produtor rural.'),(53,1400,'ENTRADAS DE MERCADORIAS SUJEITAS AO REGIME DE SUBSTITUIÇÃO TRIBUTÁRIA',''),(54,1401,'Compra para industrialização em operação com mercadoria sujeita ao regime de substituição tributária','Classificam-se neste código as compras de mercadorias a serem utilizadas em processo de industrialização, decorrentes de operações com mercadorias sujeitas ao regime de substituição tributária. Também serão classificadas neste código as compras por estabelecimento industrial de cooperativa de mercadorias sujeitas ao regime de substituição tributária.'),(55,1403,'Compra para comercialização em operação com mercadoria sujeita ao regime de substituição tributária','Classificam-se neste código as compras de mercadorias a serem comercializadas, decorrentes de operações com mercadorias sujeitas ao regime de substituição tributária. Também serão classificadas neste código as compras de mercadorias sujeitas ao regime de substituição tributária em estabelecimento comercial de cooperativa.'),(56,1406,'Compra de bem para o ativo imobilizado cuja mercadoria está sujeita ao regime de substituição tributária','Classificam-se neste código as compras de bens destinados ao ativo imobilizado do estabelecimento, em operações com mercadorias sujeitas ao regime de substituição tributária.'),(57,1407,'Compra de mercadoria para uso ou consumo cuja mercadoria está sujeita ao regime de substituição tributária','Classificam-se neste código as compras de mercadorias destinadas ao uso ou consumo do estabelecimento, em operações com mercadorias sujeitas ao regime de substituição tributária.'),(58,1408,'Transferência para industrialização em operação com mercadoria sujeita ao regime de substituição tributária','Classificam-se neste código as mercadorias recebidas em transferência de outro estabelecimento da mesma empresa, para serem industrializadas no estabelecimento, em operações com mercadorias sujeitas ao regime de substituição tributária.'),(59,1409,'Transferência para comercialização em operação com mercadoria sujeita ao regime de substituição tributária','Classificam-se neste código as mercadorias recebidas em transferência de outro estabelecimento da mesma empresa, para serem comercializadas, decorrentes de operações sujeitas ao regime de substituição tributária.'),(60,1410,'Devolução de venda de produção do estabelecimento em operação com produto sujeito ao regime de substituição tributária','Classificam-se neste código as devoluções de produtos industrializados e vendidos pelo estabelecimento, cujas saídas tenham sido classificadas como Venda de produção do estabelecimento em operação com produto sujeito ao regime de substituição tributária.'),(61,1411,'Devolução de venda de mercadoria adquirida ou recebida de terceiros em operação com mercadoria sujeita ao regime de substituição tributária','Classificam-se neste código as devoluções de vendas de mercadorias adquiridas ou recebidas de terceiros, cujas saídas tenham sido classificadas como Venda de mercadoria adquirida ou recebida de terceiros em operação com mercadoria sujeita ao regime de substituição tributária.'),(62,1414,'Retorno de produção do estabelecimento, remetida para venda fora do estabelecimento em operação com produto sujeito ao regime de substituição tributária','Classificam-se neste código as entradas, em retorno, de produtos industrializados pelo estabelecimento, remetidos para vendas fora do estabelecimento, inclusive por meio de veículos, em operações com produtos sujeitos ao regime de substituição tributária, e não comercializadas.'),(63,1415,'Retorno de mercadoria adquirida ou recebida de terceiros, remetida para venda fora do estabelecimento em operação com mercadoria sujeita ao regime de substituição tributária','Classificam-se neste código as entradas, em retorno, de mercadorias adquiridas ou recebidas de terceiros remetidas para vendas fora do estabelecimento, inclusive por meio de veículos, em operações com mercadorias sujeitas ao regime de substituição tributária, e não comercializadas.'),(64,1450,'SISTEMAS DE INTEGRAÇÃO',''),(65,1451,'Retorno de animal do estabelecimento produtor','Classificam-se neste código as entradas referentes ao retorno de animais criados pelo produtor no sistema integrado.'),(66,1452,'Retorno de insumo não utilizado na produção','Classificam-se neste código o retorno de insumos não utilizados pelo produtor na criação de animais pelo sistema integrado.'),(67,1500,'ENTRADAS DE MERCADORIAS REMETIDAS COM FIM ESPECÍFICO DE EXPORTAÇÃO E EVENTUAIS DEVOLUÇÕES',''),(68,1501,'Entrada de mercadoria recebida com fim específico de exportação','Classificam-se neste código as entradas de mercadorias em estabelecimento de trading company, empresa comercial exportadora ou outro estabelecimento do remetente, com fim específico de exportação.'),(69,1503,'Entrada decorrente de devolução de produto remetido com fim específico de exportação, de produção do estabelecimento','Classificam-se neste código as devoluções de produtos industrializados pelo estabelecimento, remetidos a trading company, a empresa comercial exportadora ou a outro estabelecimento do remetente, com fim específico de exportação, cujas saídas tenham sido classificadas no código 5.501 - Remessa de produção do estabelecimento, com fim específico de exportação.'),(70,1504,'Entrada decorrente de devolução de mercadoria remetida com fim específico de exportação, adquirida ou recebida de terceiros','Classificam-se neste código as devoluções de mercadorias adquiridas ou recebidas de terceiros remetidas a trading company, a empresa comercial exportadora ou a outro estabelecimento do remetente, com fim específico de exportação, cujas saídas tenham sido classificadas no código 5.502 - Remessa de mercadoria adquirida ou recebida de terceiros, com fim específico de exportação.'),(71,1550,'OPERAÇÕES COM BENS DE ATIVO IMOBILIZADO E MATERIAIS PARA USO OU CONSUMO',''),(72,1551,'Compra de bem para o ativo imobilizado','Classificam-se neste código as compras de bens destinados ao ativo imobilizado do estabelecimento.'),(73,1552,'Transferência de bem do ativo imobilizado','Classificam-se neste código as entradas de bens destinados ao ativo imobilizado recebidos em transferência de outro estabelecimento da mesma empresa.'),(74,1553,'Devolução de venda de bem do ativo imobilizado','Classificam-se neste código as devoluções de vendas de bens do ativo imobilizado, cujas saídas tenham sido classificadas no código 5.551 - Venda de bem do ativo imobilizado.'),(75,1554,'Retorno de bem do ativo imobilizado remetido para uso fora do estabelecimento','Classificam-se neste código as entradas por retorno de bens do ativo imobilizado remetidos para uso fora do estabelecimento, cujas saídas tenham sido classificadas no código 5.554 - Remessa de bem do ativo imobilizado para uso fora do estabelecimento.'),(76,1555,'Entrada de bem do ativo imobilizado de terceiro, remetido para uso no estabelecimento','Classificam-se neste código as entradas de bens do ativo imobilizado de terceiros, remetidos para uso no estabelecimento.'),(77,1556,'Compra de material para uso ou consumo','Classificam-se neste código as compras de mercadorias destinadas ao uso ou consumo do estabelecimento.'),(78,1557,'Transferência de material para uso ou consumo','Classificam-se neste código as entradas de materiais para uso ou consumo recebidos em transferência de outro estabelecimento da mesma empresa.'),(79,1600,'CRÉDITOS E RESSARCIMENTOS DE ICMS',''),(80,1601,'Recebimento, por transferência, de crédito de ICMS','Classificam-se neste código os lançamentos destinados ao registro de créditos de ICMS, recebidos por transferência de outras empresas.'),(81,1602,'Recebimento, por transferência, de saldo credor de ICMS de outro estabelecimento da mesma empresa, para compensação de saldo devedor de ICMS','Classificam-se neste código os lançamentos destinados ao registro da transferência de saldos credores de ICMS recebidos de outros estabelecimentos da mesma empresa, destinados à compensação do saldo devedor do estabelecimento.'),(82,1603,'Ressarcimento de ICMS retido por substituição tributária','Classificam-se neste código os lançamentos destinados ao registro de ressarcimento de ICMS retido por substituição tributária a contribuinte substituído, efetuado pelo contribuinte substituto, ou, ainda, quando o ressarcimento for apropriado pelo próprio contribuinte substituído, nas hipóteses previstas na legislação aplicável.'),(83,1604,'Lançamento do crédito relativo à compra de bem para o ativo imobilizado','Lançamento destinado ao registro da apropriação de crédito de bem do ativo imobilizado.'),(84,1605,'1.605 – Recebimento, por transferência, de saldo devedor de ICMS de outro estabelecimento da mesma empresa. (Ajuste SINIEF 03/04)','Classificam-se neste código os lançamentos destinados ao registro da transferência de saldo devedor de ICMS recebido de outro estabelecimento da mesma empresa, para efetivação da apuração centralizada do imposto.\n'),(85,1900,'OUTRAS ENTRADAS DE MERCADORIAS OU AQUISIÇÕES DE SERVIÇOS',''),(86,1901,'Entrada para industrialização por encomenda','Classificam-se neste código as entradas de insumos recebidos para industrialização por encomenda de outra empresa ou de outro estabelecimento da mesma empresa.'),(87,1902,'Retorno de mercadoria remetida para industrialização por encomenda','Classificam-se neste código o retorno dos insumos remetidos para industrialização por encomenda, incorporados ao produto final pelo estabelecimento industrializador.'),(88,1903,'Entrada de mercadoria remetida para industrialização e não aplicada no referido processo','Classificam-se neste código as entradas em devolução de insumos remetidos para industrialização e não aplicados no referido processo.'),(89,1904,'Retorno de remessa para venda fora do estabelecimento','Classificam-se neste código as entradas em retorno de mercadorias remetidas para venda fora do estabelecimento, inclusive por meio de veículos, e não comercializadas.'),(90,1905,'Entrada de mercadoria recebida para depósito em depósito fechado ou armazém geral','Classificam-se neste código as entradas de mercadorias recebidas para depósito em depósito fechado ou armazém geral.'),(91,1906,'Retorno de mercadoria remetida para depósito fechado ou armazém geral','Classificam-se neste código as entradas em retorno de mercadorias remetidas para depósito em depósito fechado ou armazém geral.'),(92,1907,'Retorno simbólico de mercadoria remetida para depósito fechado ou armazém geral','Classificam-se neste código as entradas em retorno simbólico de mercadorias remetidas para depósito em depósito fechado ou armazém geral, quando as mercadorias depositadas tenham sido objeto de saída a qualquer título e que não tenham retornado ao estabelecimento depositante.'),(93,1908,'Entrada de bem por conta de contrato de comodato','Classificam-se neste código as entradas de bens recebidos em cumprimento de contrato de comodato.'),(94,1909,'Retorno de bem remetido por conta de contrato de comodato','Classificam-se neste código as entradas de bens recebidos em devolução após cumprido o contrato de comodato.'),(95,1910,'Entrada de bonificação, doação ou brinde','Classificam-se neste código as entradas de mercadorias recebidas a título de bonificação, doação ou brinde.'),(96,1911,'Entrada de amostra grátis','Classificam-se neste código as entradas de mercadorias recebidas a título de amostra grátis.'),(97,1912,'Entrada de mercadoria ou bem recebido para demonstração','Classificam-se neste código as entradas de mercadorias ou bens recebidos para demonstração.'),(98,1913,'Retorno de mercadoria ou bem remetido para demonstração','Classificam-se neste código as entradas em retorno de mercadorias ou bens remetidos para demonstração.'),(99,1914,'Retorno de mercadoria ou bem remetido para exposição ou feira','Classificam-se neste código as entradas em retorno de mercadorias ou bens remetidos para exposição ou feira.'),(100,1915,'Entrada de mercadoria ou bem recebido para conserto ou reparo','Classificam-se neste código as entradas de mercadorias ou bens recebidos para conserto ou reparo.'),(101,1916,'Retorno de mercadoria ou bem remetido para conserto ou reparo','Classificam-se neste código as entradas em retorno de mercadorias ou bens remetidos para conserto ou reparo.'),(102,1917,'Entrada de mercadoria recebida em consignação mercantil ou industrial','Classificam-se neste código as entradas de mercadorias recebidas a título de consignação mercantil ou industrial.'),(103,1918,'Devolução de mercadoria remetida em consignação mercantil ou industrial','Classificam-se neste código as entradas por devolução de mercadorias remetidas anteriormente a título de consignação mercantil ou industrial.'),(104,1919,'Devolução simbólica de mercadoria vendida ou utilizada em processo industrial, remetida anteriormente em consignação mercantil ou industrial','Classificam-se neste código as entradas por devolução simbólica de mercadorias vendidas ou utilizadas em processo industrial, remetidas anteriormente a título de consignação mercantil ou industrial.'),(105,1920,'Entrada de vasilhame ou sacaria','Classificam-se neste código as entradas de vasilhame ou sacaria.'),(106,1921,'Retorno de vasilhame ou sacaria','Classificam-se neste código as entradas em retorno de vasilhame ou sacaria.'),(107,1922,'Lançamento efetuado a título de simples faturamento decorrente de compra para recebimento futuro','Classificam-se neste código os registros efetuados a título de simples faturamento decorrente de compra para recebimento futuro.'),(108,1923,'Entrada de mercadoria recebida do vendedor remetente, em venda à ordem','Classificam-se neste código as entradas de mercadorias recebidas do vendedor remetente, em vendas à ordem, cuja compra do adquirente originário, foi classificada nos códigos 1.120 - Compra para industrialização, em venda à ordem, já recebida do vendedor remetente ou 1.121 - Compra para comercialização, em venda à ordem, já recebida do vendedor remetente.'),(109,1924,'Entrada para industrialização por conta e ordem do adquirente da mercadoria, quando esta não transitar pelo estabelecimento do adquirente','Classificam-se neste código as entradas de insumos recebidos para serem industrializados por conta e ordem do adquirente, nas hipóteses em que os insumos não tenham transitado pelo estabelecimento do adquirente dos mesmos.'),(110,1925,'Retorno de mercadoria remetida para industrialização por conta e ordem do adquirente da mercadoria, quando esta não transitar pelo estabelecimento do adquirente','Classificam-se neste código o retorno dos insumos remetidos por conta e ordem do adquirente, para industrialização e incorporados ao produto final pelo estabelecimento industrializador, nas hipóteses em que os insumos não tenham transitado pelo estabelecimento do adquirente.'),(111,1926,'Lançamento efetuado a título de reclassificação de mercadoria decorrente de formação de kit ou de sua desagregação','Classificam-se neste código os registros efetuados a título de reclassificação decorrente de formação de kit de mercadorias ou de sua desagregação.'),(112,1931,'Lançamento efetuado pelo tomador do serviço de transporte quando a responsabilidade de retenção do imposto for atribuída ao remetente ou alienante da mercadoria, pelo serviço de transporte realizado por transportador autônomo ou por transportador não inscrito na unidade da Federação onde iniciado o serviço. (Ajuste SINIEF 03/04)','Classificam-se neste código exclusivamente os lançamentos efetuados pelo tomador do serviço de transporte realizado por transportador autônomo ou por transportador não inscrito na unidade da Federação, onde iniciado o serviço, quando a responsabilidade pela retenção do imposto for atribuída ao remetente ou alienante da mercadoria.\n'),(113,1932,'Aquisição de serviço de transporte iniciado em unidade da Federação diversa daquela onde inscrito o prestador. (ajuste sinief 03/04)','Classificam-se neste código as aquisições de serviços de transporte que tenham sido iniciados em unidade da Federação diversa daquela onde o prestador está inscrito como contribuinte.\n'),(114,1933,'Aquisição de serviço tributado pelo ISSQN.(ajuste sinief 03/04)','Classificam-se neste código as aquisições de serviços, de competência municipal, desde que informados em documentos autorizados pelo Estado.\n'),(115,1949,'Outra entrada de mercadoria ou prestação de serviço não especificada','Classificam-se neste código as outras entradas de mercadorias ou prestações de serviços que não tenham sido especificadas nos códigos anteriores.'),(116,2000,'ENTRADAS OU AQUISIÇÕES DE SERVIÇOS DE OUTROS ESTADOS','Classificam-se, neste grupo, as operações ou prestações em que o estabelecimento remetente esteja localizado em unidade da Federação diversa daquela do destinatário'),(117,2100,'COMPRAS PARA INDUSTRIALIZAÇÃO, COMERCIALIZAÇÃO OU PRESTAÇÃO DE SERVIÇOS',''),(118,2101,'Compra para industrialização','Classificam-se neste código as compras de mercadorias a serem utilizadas em processo de industrialização. Também serão classificadas neste código as entradas de mercadorias em estabelecimento industrial de cooperativa recebidas de seus cooperados ou de estabelecimento de outra cooperativa.'),(119,2102,'Compra para comercialização','Classificam-se neste código as compras de mercadorias a serem comercializadas. Também serão classificadas neste código as entradas de mercadorias em estabelecimento comercial de cooperativa recebidas de seus cooperados ou de estabelecimento de outra cooperativa.'),(120,2111,'Compra para industrialização de mercadoria recebida anteriormente em consignação industrial','Classificam-se neste código as compras efetivas de mercadorias a serem utilizadas em processo de industrialização, recebidas anteriormente a título de consignação industrial.'),(121,2113,'Compra para comercialização, de mercadoria recebida anteriormente em consignação mercantil','Classificam-se neste código as compras efetivas de mercadorias recebidas anteriormente a título de consignação mercantil.'),(122,2116,'Compra para industrialização originada de encomenda para recebimento futuro','Classificam-se neste código as compras de mercadorias a serem utilizadas em processo de industrialização, quando da entrada real da mercadoria, cuja aquisição tenha sido classificada no código 2.922 - Lançamento efetuado a título de simples faturamento decorrente de compra para recebimento futuro.'),(123,2117,'Compra para comercialização originada de encomenda para recebimento futuro','Classificam-se neste código as compras de mercadorias a serem comercializadas, quando da entrada real da mercadoria, cuja aquisição tenha sido classificada no código 2.922 - Lançamento efetuado a título de simples faturamento decorrente de compra para recebimento futuro.'),(124,2118,'Compra de mercadoria para comercialização pelo adquirente originário, entregue pelo vendedor remetente ao destinatário, em venda à ordem','Classificam-se neste código as compras de mercadorias já comercializadas, que, sem transitar pelo estabelecimento do adquirente originário, sejam entregues pelo vendedor remetente diretamente ao destinatário, em operação de venda à ordem, cuja venda seja classificada, pelo adquirente originário, no código 6.120 - Venda de mercadoria adquirida ou recebida de terceiros entregue ao destinatário pelo vendedor remetente, em venda à ordem.'),(125,2120,'Compra para industrialização, em venda à ordem, já recebida do vendedor remetente','Classificam-se neste código as compras de mercadorias a serem utilizadas em processo de industrialização, em vendas à ordem, já recebidas do vendedor remetente, por ordem do adquirente originário.'),(126,2121,'Compra para comercialização, em venda à ordem, já recebida do vendedor remetente','Classificam-se neste código as compras de mercadorias a serem comercializadas, em vendas à ordem, já recebidas do vendedor remetente por ordem do adquirente originário.'),(127,2122,'Compra para industrialização em que a mercadoria foi remetida pelo fornecedor ao industrializador sem transitar pelo estabelecimento adquirente','Classificam-se neste código as compras de mercadorias a serem utilizadas em processo de industrialização, remetidas pelo fornecedor para o industrializador sem que a mercadoria tenha transitado pelo estabelecimento do adquirente.'),(128,2124,'Industrialização efetuada por outra empresa','Classificam-se neste código as entradas de mercadorias industrializadas por terceiros, compreendendo os valores referentes aos serviços prestados e os das mercadorias de propriedade do industrializador empregadas no processo industrial. Quando a industrialização efetuada se referir a bens do ativo imobilizado ou de mercadorias para uso ou consumo do estabelecimento encomendante, a entrada deverá ser classificada nos códigos 2.551 - Compra de bem para o ativo imobilizado ou 2.556 - Compra de material para uso ou consumo.'),(129,2125,'Industrialização efetuada por outra empresa quando a mercadoria remetida para utilização no processo de industrialização não transitou pelo estabelecimento adquirente da mercadoria','Classificam-se neste código as entradas de mercadorias industrializadas por outras empresas, em que as mercadorias remetidas para utilização no processo de industrialização não transitaram pelo estabelecimento do adquirente das mercadorias, compreendendo os valores referentes aos serviços prestados e os das mercadorias de propriedade do industrializador empregadas no processo industrial. Quando a industrialização efetuada se referir a bens do ativo imobilizado ou de mercadorias para uso ou consumo do estabelecimento encomendante, a entrada deverá ser classificada nos códigos 2.551 - Compra de bem para o ativo imobilizado ou 2.556 - Compra de material para uso ou consumo.'),(130,2126,'Compra para utilização na prestação de serviço','Classificam-se neste código as entradas de mercadorias a serem utilizadas nas prestações de serviços.'),(131,2150,'TRANSFERÊNCIAS PARA INDUSTRIALIZAÇÃO, COMERCIALIZAÇÃO OU PRESTAÇÃO DE SERVIÇOS',''),(132,2151,'Transferência para industrialização','Classificam-se neste código as entradas de mercadorias recebidas em transferência de outro estabelecimento da mesma empresa, para serem utilizadas em processo de industrialização.'),(133,2152,'Transferência para comercialização','Classificam-se neste código as entradas de mercadorias recebidas em transferência de outro estabelecimento da mesma empresa, para serem comercializadas.'),(134,2153,'Transferência de energia elétrica para distribuição','Classificam-se neste código as entradas de energia elétrica recebida em transferência de outro estabelecimento da mesma empresa, para distribuição.'),(135,2154,'Transferência para utilização na prestação de serviço','Classificam-se neste código as entradas de mercadorias recebidas em transferência de outro estabelecimento da mesma empresa, para serem utilizadas nas prestações de serviços.'),(136,2200,'DEVOLUÇÕES DE VENDAS DE PRODUÇÃO PRÓPRIA, DE TERCEIROS OU ANULAÇÕES DE VALORES',''),(137,2201,'Devolução de venda de produção do estabelecimento','Classificam-se neste código as devoluções de vendas de produtos industrializados pelo estabelecimento, cujas saídas tenham sido classificadas como Venda de produção do estabelecimento.'),(138,2202,'Devolução de venda de mercadoria adquirida ou recebida de terceiros','Classificam-se neste código as devoluções de vendas de mercadorias adquiridas ou recebidas de terceiros, que não tenham sido objeto de industrialização no estabelecimento, cujas saídas tenham sido classificadas como Venda de mercadoria adquirida ou recebida de terceiros.'),(139,2203,'Devolução de venda de produção do estabelecimento, destinada à Zona Franca de Manaus ou Áreas de Livre Comércio','Classificam-se neste código as devoluções de vendas de produtos industrializados pelo estabelecimento, cujas saídas foram classificadas no código 6.109 - Venda de produção do estabelecimento, destinada à Zona Franca de Manaus ou Áreas de Livre Comércio.'),(140,2204,'Devolução de venda de mercadoria adquirida ou recebida de terceiros, destinada à Zona Franca de Manaus ou Áreas de Livre Comércio','Classificam-se neste código as devoluções de vendas de mercadorias adquiridas ou recebidas de terceiros, cujas saídas foram classificadas no código 6.110 - Venda de mercadoria adquirida ou recebida de terceiros, destinada à Zona Franca de Manaus ou Áreas de Livre Comércio.'),(141,2205,'Anulação de valor relativo à prestação de serviço de comunicação','Classificam-se neste código as anulações correspondentes a valores faturados indevidamente, decorrentes de prestações de serviços de comunicação.'),(142,2206,'Anulação de valor relativo à prestação de serviço de transporte','Classificam-se neste código as anulações correspondentes a valores faturados indevidamente, decorrentes de prestações de serviços de transporte.'),(143,2207,'Anulação de valor relativo à venda de energia elétrica','Classificam-se neste código as anulações correspondentes a valores faturados indevidamente, decorrentes de venda de energia elétrica.'),(144,2208,'Devolução de produção do estabelecimento, remetida em transferência','Classificam-se neste código as devoluções de produtos industrializados pelo estabelecimento, transferidos para outros estabelecimentos da mesma empresa.'),(145,2209,'Devolução de mercadoria adquirida ou recebida de terceiros, remetida em transferência','Classificam-se neste código as devoluções de mercadorias adquiridas ou recebidas de terceiros, transferidas para outros estabelecimentos da mesma empresa.'),(146,2250,'COMPRAS DE ENERGIA ELÉTRICA',''),(147,2251,'Compra de energia elétrica para distribuição ou comercialização','Classificam-se neste código as compras de energia elétrica utilizada em sistema de distribuição ou comercialização. Também serão classificadas neste código as compras de energia elétrica por cooperativas para distribuição aos seus cooperados.'),(148,2252,'Compra de energia elétrica por estabelecimento industrial','Classificam-se neste código as compras de energia elétrica utilizada no processo de industrialização. Também serão classificadas neste código as compras de energia elétrica utilizada por estabelecimento industrial de cooperativa.'),(149,2253,'Compra de energia elétrica por estabelecimento comercial','Classificam-se neste código as compras de energia elétrica utilizada por estabelecimento comercial. Também serão classificadas neste código as compras de energia elétrica utilizada por estabelecimento comercial de cooperativa.'),(150,2254,'Compra de energia elétrica por estabelecimento prestador de serviço de transporte','Classificam-se neste código as compras de energia elétrica utilizada por estabelecimento prestador de serviços de transporte.'),(151,2255,'Compra de energia elétrica por estabelecimento prestador de serviço de comunicação','Classificam-se neste código as compras de energia elétrica utilizada por estabelecimento prestador de serviços de comunicação.'),(152,2256,'Compra de energia elétrica por estabelecimento de produtor rural','Classificam-se neste código as compras de energia elétrica utilizada por estabelecimento de produtor rural.'),(153,2257,'Compra de energia elétrica para consumo por demanda contratada','Classificam-se neste código as compras de energia elétrica para consumo por demanda contratada, que prevalecerá sobre os demais códigos deste subgrupo.'),(154,2300,'AQUISIÇÕES DE SERVIÇOS DE COMUNICAÇÃO',''),(155,2301,'Aquisição de serviço de comunicação para execução de serviço da mesma natureza','Classificam-se neste código as aquisições de serviços de comunicação utilizados nas prestações de serviços da mesma natureza.'),(156,2302,'Aquisição de serviço de comunicação por estabelecimento industrial','Classificam-se neste código as aquisições de serviços de comunicação utilizados por estabelecimento industrial. Também serão classificadas neste código as aquisições de serviços de comunicação utilizados por estabelecimento industrial de cooperativa.'),(157,2303,'Aquisição de serviço de comunicação por estabelecimento comercial','Classificam-se neste código as aquisições de serviços de comunicação utilizados por estabelecimento comercial. Também serão classificadas neste código as aquisições de serviços de comunicação utilizados por estabelecimento comercial de cooperativa.'),(158,2304,'Aquisição de serviço de comunicação por estabelecimento de prestador de serviço de transporte','Classificam-se neste código as aquisições de serviços de comunicação utilizado por estabelecimento prestador de serviço de transporte.'),(159,2305,'Aquisição de serviço de comunicação por estabelecimento de geradora ou de distribuidora de energia elétrica','Classificam-se neste código as aquisições de serviços de comunicação utilizados por estabelecimento de geradora ou de distribuidora de energia elétrica.'),(160,2306,'Aquisição de serviço de comunicação por estabelecimento de produtor rural','Classificam-se neste código as aquisições de serviços de comunicação utilizados por estabelecimento de produtor rural.'),(161,2350,'AQUISIÇÕES DE SERVIÇOS DE TRANSPORTE',''),(162,2351,'Aquisição de serviço de transporte para execução de serviço da mesma natureza','Classificam-se neste código as aquisições de serviços de transporte utilizados nas prestações de serviços da mesma natureza.'),(163,2352,'Aquisição de serviço de transporte por estabelecimento industrial','Classificam-se neste código as aquisições de serviços de transporte utilizados por estabelecimento industrial. Também serão classificadas neste código as aquisições de serviços de transporte utilizados por estabelecimento industrial de cooperativa.'),(164,2353,'Aquisição de serviço de transporte por estabelecimento comercial','Classificam-se neste código as aquisições de serviços de transporte utilizados por estabelecimento comercial. Também serão classificadas neste código as aquisições de serviços de transporte utilizados por estabelecimento comercial de cooperativa.'),(165,2354,'Aquisição de serviço de transporte por estabelecimento de prestador de serviço de comunicação','Classificam-se neste código as aquisições de serviços de transporte utilizados por estabelecimento prestador de serviços de comunicação.'),(166,2355,'Aquisição de serviço de transporte por estabelecimento de geradora ou de distribuidora de energia elétrica','Classificam-se neste código as aquisições de serviços de transporte utilizados por estabelecimento de geradora ou de distribuidora de energia elétrica.'),(167,2356,'Aquisição de serviço de transporte por estabelecimento de produtor rural','Classificam-se neste código as aquisições de serviços de transporte utilizados por estabelecimento de produtor rural.'),(168,2400,'ENTRADAS DE MERCADORIAS SUJEITAS AO REGIME DE SUBSTITUIÇÃO TRIBUTÁRIA',''),(169,2401,'Compra para industrialização em operação com mercadoria sujeita ao regime de substituição tributária','Classificam-se neste código as compras de mercadorias a serem utilizadas em processo de industrialização, decorrentes de operações com mercadorias sujeitas ao regime de substituição tributária. Também serão classificadas neste código as compras por estabelecimento industrial de cooperativa de mercadorias sujeitas ao regime de substituição tributária.'),(170,2403,'Compra para comercialização em operação com mercadoria sujeita ao regime de substituição tributária','Classificam-se neste código as compras de mercadorias a serem comercializadas, decorrentes de operações com mercadorias sujeitas ao regime de substituição tributária. Também serão classificadas neste código as compras de mercadorias sujeitas ao regime de substituição tributária em estabelecimento comercial de cooperativa.'),(171,2406,'Compra de bem para o ativo imobilizado cuja mercadoria está sujeita ao regime de substituição tributária','Classificam-se neste código as compras de bens destinados ao ativo imobilizado do estabelecimento, em operações com mercadorias sujeitas ao regime de substituição tributária.'),(172,2407,'Compra de mercadoria para uso ou consumo cuja mercadoria está sujeita ao regime de substituição tributária','Classificam-se neste código as compras de mercadorias destinadas ao uso ou consumo do estabelecimento, em operações com mercadorias sujeitas ao regime de substituição tributária.'),(173,2408,'Transferência para industrialização em operação com mercadoria sujeita ao regime de substituição tributária','Classificam-se neste código as mercadorias recebidas em transferência de outro estabelecimento da mesma empresa, para serem industrializadas no estabelecimento, em operações com mercadorias sujeitas ao regime de substituição tributária.'),(174,2409,'Transferência para comercialização em operação com mercadoria sujeita ao regime de substituição tributária','Classificam-se neste código as mercadorias recebidas em transferência de outro estabelecimento da mesma empresa, para serem comercializadas, decorrentes de operações sujeitas ao regime de substituição tributária.'),(175,2410,'Devolução de venda de produção do estabelecimento em operação com produto sujeito ao regime de substituição tributária','Classificam-se neste código as devoluções de produtos industrializados e vendidos pelo estabelecimento, cujas saídas tenham sido classificadas como Venda de produção do estabelecimento em operação com produto sujeito ao regime de substituição tributária.'),(176,2411,'Devolução de venda de mercadoria adquirida ou recebida de terceiros em operação com mercadoria sujeita ao regime de substituição tributária','Classificam-se neste código as devoluções de vendas de mercadorias adquiridas ou recebidas de terceiros, cujas saídas tenham sido classificadas como Venda de mercadoria adquirida ou recebida de terceiros em operação com mercadoria sujeita ao regime de substituição tributária.'),(177,2414,'Retorno de produção do estabelecimento, remetida para venda fora do estabelecimento em operação com produto sujeito ao regime de substituição tributária','Classificam-se neste código as entradas, em retorno, de produtos industrializados pelo estabelecimento, remetidos para vendas fora do estabelecimento, inclusive por meio de veículos, em operações com produtos sujeitos ao regime de substituição tributária, e não comercializadas.'),(178,2415,'Retorno de mercadoria adquirida ou recebida de terceiros, remetida para venda fora do estabelecimento em operação com mercadoria sujeita ao regime de substituição tributária','Classificam-se neste código as entradas, em retorno, de mercadorias adquiridas ou recebidas de terceiros remetidas para vendas fora do estabelecimento, inclusive por meio de veículos, em operações com mercadorias sujeitas ao regime de substituição tributária, e não comercializadas.'),(179,2500,'ENTRADAS DE MERCADORIAS REMETIDAS COM FIM ESPECÍFICO DE EXPORTAÇÃO E EVENTUAIS DEVOLUÇÕES',''),(180,2501,'Entrada de mercadoria recebida com fim específico de exportação','Classificam-se neste código as entradas de mercadorias em estabelecimento de trading company, empresa comercial exportadora ou outro estabelecimento do remetente, com fim específico de exportação.'),(181,2503,'Entrada decorrente de devolução de produto remetido com fim específico de exportação, de produção do estabelecimento','Classificam-se neste código as devoluções de produtos industrializados pelo estabelecimento, remetidos a trading company, a empresa comercial exportadora ou a outro estabelecimento do remetente, com fim específico de exportação, cujas saídas tenham sido classificadas no código 6.501 - Remessa de produção do estabelecimento, com fim específico de exportação.'),(182,2504,'Entrada decorrente de devolução de mercadoria remetida com fim específico de exportação, adquirida ou recebida de terceiros','Classificam-se neste código as devoluções de mercadorias adquiridas ou recebidas de terceiros remetidas a trading company, a empresa comercial exportadora ou a outro estabelecimento do remetente, com fim específico de exportação, cujas saídas tenham sido classificadas no código 6.502 - Remessa de mercadoria adquirida ou recebida de terceiros, com fim específico de exportação.'),(183,2550,'OPERAÇÕES COM BENS DE ATIVO IMOBILIZADO E MATERIAIS PARA USO OU CONSUMO',''),(184,2551,'Compra de bem para o ativo imobilizado','Classificam-se neste código as compras de bens destinados ao ativo imobilizado do estabelecimento.'),(185,2552,'Transferência de bem do ativo imobilizado','Classificam-se neste código as entradas de bens destinados ao ativo imobilizado recebidos em transferência de outro estabelecimento da mesma empresa.'),(186,2553,'Devolução de venda de bem do ativo imobilizado','Classificam-se neste código as devoluções de vendas de bens do ativo imobilizado, cujas saídas tenham sido classificadas no código 6.551 - Venda de bem do ativo imobilizado.'),(187,2554,'Retorno de bem do ativo imobilizado remetido para uso fora do estabelecimento','Classificam-se neste código as entradas por retorno de bens do ativo imobilizado remetidos para uso fora do estabelecimento, cujas saídas tenham sido classificadas no código 6.554 - Remessa de bem do ativo imobilizado para uso fora do estabelecimento.'),(188,2555,'Entrada de bem do ativo imobilizado de terceiro, remetido para uso no estabelecimento','Classificam-se neste código as entradas de bens do ativo imobilizado de terceiros, remetidos para uso no estabelecimento.'),(189,2556,'Compra de material para uso ou consumo','Classificam-se neste código as compras de mercadorias destinadas ao uso ou consumo do estabelecimento.'),(190,2557,'Transferência de material para uso ou consumo','Classificam-se neste código as entradas de materiais para uso ou consumo recebidos em transferência de outro estabelecimento da mesma empresa.'),(191,2600,'CRÉDITOS E RESSARCIMENTOS DE ICMS',''),(192,2603,'Ressarcimento de ICMS retido por substituição tributária','Classificam-se neste código os lançamentos destinados ao registro de ressarcimento de ICMS retido por substituição tributária a contribuinte substituído, efetuado pelo contribuinte substituto, nas hipóteses previstas na legislação aplicável.'),(193,2900,'OUTRAS ENTRADAS DE MERCADORIAS OU AQUISIÇÕES DE SERVIÇOS',''),(194,2901,'Entrada para industrialização por encomenda','Classificam-se neste código as entradas de insumos recebidos para industrialização por encomenda de outra empresa ou de outro estabelecimento da mesma empresa.'),(195,2902,'Retorno de mercadoria remetida para industrialização por encomenda','Classificam-se neste código o retorno dos insumos remetidos para industrialização por encomenda, incorporados ao produto final pelo estabelecimento industrializador.'),(196,2903,'Entrada de mercadoria remetida para industrialização e não aplicada no referido processo','Classificam-se neste código as entradas em devolução de insumos remetidos para industrialização e não aplicados no referido processo.'),(197,2904,'Retorno de remessa para venda fora do estabelecimento','Classificam-se neste código as entradas em retorno de mercadorias remetidas para venda fora do estabelecimento, inclusive por meio de veículos, e não comercializadas.'),(198,2905,'Entrada de mercadoria recebida para depósito em depósito fechado ou armazém geral','Classificam-se neste código as entradas de mercadorias recebidas para depósito em depósito fechado ou armazém geral.'),(199,2906,'Retorno de mercadoria remetida para depósito fechado ou armazém geral','Classificam-se neste código as entradas em retorno de mercadorias remetidas para depósito em depósito fechado ou armazém geral.'),(200,2907,'Retorno simbólico de mercadoria remetida para depósito fechado ou armazém geral','Classificam-se neste código as entradas em retorno simbólico de mercadorias remetidas para depósito em depósito fechado ou armazém geral, quando as mercadorias depositadas tenham sido objeto de saída a qualquer título e que não tenham retornado ao estabelecimento depositante.'),(201,2908,'Entrada de bem por conta de contrato de comodato','Classificam-se neste código as entradas de bens recebidos em cumprimento de contrato de comodato.'),(202,2909,'Retorno de bem remetido por conta de contrato de comodato','Classificam-se neste código as entradas de bens recebidos em devolução após cumprido o contrato de comodato.'),(203,2910,'Entrada de bonificação, doação ou brinde','Classificam-se neste código as entradas de mercadorias recebidas a título de bonificação, doação ou brinde.'),(204,2911,'Entrada de amostra grátis','Classificam-se neste código as entradas de mercadorias recebidas a título de amostra grátis.'),(205,2912,'Entrada de mercadoria ou bem recebido para demonstração','Classificam-se neste código as entradas de mercadorias ou bens recebidos para demonstração.'),(206,2913,'Retorno de mercadoria ou bem remetido para demonstração','Classificam-se neste código as entradas em retorno de mercadorias ou bens remetidos para demonstração.'),(207,2914,'Retorno de mercadoria ou bem remetido para exposição ou feira','Classificam-se neste código as entradas em retorno de mercadorias ou bens remetidos para exposição ou feira.'),(208,2915,'Entrada de mercadoria ou bem recebido para conserto ou reparo','Classificam-se neste código as entradas de mercadorias ou bens recebidos para conserto ou reparo.'),(209,2916,'Retorno de mercadoria ou bem remetido para conserto ou reparo','Classificam-se neste código as entradas em retorno de mercadorias ou bens remetidos para conserto ou reparo.'),(210,2917,'Entrada de mercadoria recebida em consignação mercantil ou industrial','Classificam-se neste código as entradas de mercadorias recebidas a título de consignação mercantil ou industrial.'),(211,2918,'Devolução de mercadoria remetida em consignação mercantil ou industrial','Classificam-se neste código as entradas por devolução de mercadorias remetidas anteriormente a título de consignação mercantil ou industrial.'),(212,2919,'Devolução simbólica de mercadoria vendida ou utilizada em processo industrial, remetida anteriormente em consignação mercantil ou industrial','Classificam-se neste código as entradas por devolução simbólica de mercadorias vendidas ou utilizadas em processo industrial, remetidas anteriormente a título de consignação mercantil ou industrial.'),(213,2920,'Entrada de vasilhame ou sacaria','Classificam-se neste código as entradas de vasilhame ou sacaria.'),(214,2921,'Retorno de vasilhame ou sacaria','Classificam-se neste código as entradas em retorno de vasilhame ou sacaria.'),(215,2922,'Lançamento efetuado a título de simples faturamento decorrente de compra para recebimento futuro','Classificam-se neste código os registros efetuados a título de simples faturamento decorrente de compra para recebimento futuro.'),(216,2923,'Entrada de mercadoria recebida do vendedor remetente, em venda à ordem','Classificam-se neste código as entradas de mercadorias recebidas do vendedor remetente, em vendas à ordem, cuja compra do adquirente originário, foi classificada nos códigos 2.120 - Compra para industrialização, em venda à ordem, já recebida do vendedor remetente ou 2.121 - Compra para comercialização, em venda à ordem, já recebida do vendedor remetente.'),(217,2924,'Entrada para industrialização por conta e ordem do adquirente da mercadoria, quando esta não transitar pelo estabelecimento do adquirente','Classificam-se neste código as entradas de insumos recebidos para serem industrializados por conta e ordem do adquirente, nas hipóteses em que os insumos não tenham transitado pelo estabelecimento do adquirente dos mesmos.'),(218,2925,'Retorno de mercadoria remetida para industrialização por conta e ordem do adquirente da mercadoria, quando esta não transitar pelo estabelecimento do adquirente','Classificam-se neste código o retorno dos insumos remetidos por conta e ordem do adquirente, para industrialização e incorporados ao produto final pelo estabelecimento industrializador, nas hipóteses em que os insumos não tenham transitado pelo estabelecimento do adquirente.'),(219,2931,'Lançamento efetuado pelo tomador do serviço de transporte quando a responsabilidade de retenção do imposto for atribuída ao remetente ou alienante da mercadoria, pelo serviço de transporte realizado por transportador autônomo ou por transportador não inscrito na unidade da Federação onde iniciado o serviço. (ajuste sinief 03/04)','Classificam-se neste código exclusivamente os lançamentos efetuados pelo tomador do serviço de transporte realizado por transportador autônomo ou por transportador não inscrito na unidade da Federação, onde iniciado o serviço, quando a responsabilidade pela retenção do imposto for atribuída ao remetente ou alienante da mercadoria.\n'),(220,2932,'Aquisição de serviço de transporte iniciado em unidade da Federação diversa daquela onde inscrito o prestador. (ajuste sinief 03/04)','Classificam-se neste código as aquisições de serviços de transporte que tenham sido iniciados em unidade da Federação diversa daquela onde o prestador está inscrito como contribuinte.\n'),(221,2933,'Aquisição de serviço tributado pelo ISSQN. (ajuste sinief 03/04)','Classificam-se neste código as aquisições de serviços, de competência municipal, desde que informados em documentos autorizados pelo Estado.\n'),(222,2949,'Outra entrada de mercadoria ou prestação de serviço não especificado','Classificam-se neste código as outras entradas de mercadorias ou prestações de serviços que não tenham sido especificados nos códigos anteriores.'),(223,3000,'ENTRADAS OU AQUISIÇÕES DE SERVIÇOS DO EXTERIOR','Classificam-se, neste grupo, as entradas de mercadorias oriundas de outro país, inclusive as decorrentes de aquisição por arrematação, concorrência ou qualquer outra forma de alienação promovida pelo poder público, e os serviços iniciados no exterior'),(224,3100,'COMPRAS PARA INDUSTRIALIZAÇÃO, COMERCIALIZAÇÃO OU PRESTAÇÃO DE SERVIÇOS',''),(225,3101,'Compra para industrialização','Classificam-se neste código as compras de mercadorias a serem utilizadas em processo de industrialização. Também serão classificadas neste código as entradas de mercadorias em estabelecimento industrial de cooperativa.'),(226,3102,'Compra para comercialização','Classificam-se neste código as compras de mercadorias a serem comercializadas. Também serão classificadas neste código as entradas de mercadorias em estabelecimento comercial de cooperativa.'),(227,3126,'Compra para utilização na prestação de serviço','Classificam-se neste código as entradas de mercadorias a serem utilizadas nas prestações de serviços.'),(228,3127,'Compra para industrialização sob o regime de drawback ','Classificam-se neste código as compras de mercadorias a serem utilizadas em processo de industrialização e posterior exportação do produto resultante, cujas vendas serão classificadas no código 7.127 - Venda de produção do estabelecimento sob o regime de drawback.'),(229,3200,'DEVOLUÇÕES DE VENDAS DE PRODUÇÃO PRÓPRIA, DE TERCEIROS OU ANULAÇÕES DE VALORES',''),(230,3201,'Devolução de venda de produção do estabelecimento','Classificam-se neste código as devoluções de vendas de produtos industrializados pelo estabelecimento, cujas saídas tenham sido classificadas como Venda de produção do estabelecimento.'),(231,3202,'Devolução de venda de mercadoria adquirida ou recebida de terceiros','Classificam-se neste código as devoluções de vendas de mercadorias adquiridas ou recebidas de terceiros, que não tenham sido objeto de industrialização no estabelecimento, cujas saídas tenham sido classificadas como Venda de mercadoria adquirida ou recebida de terceiros.'),(232,3205,'Anulação de valor relativo à prestação de serviço de comunicação','Classificam-se neste código as anulações correspondentes a valores faturados indevidamente, decorrentes de prestações de serviços de comunicação.'),(233,3206,'Anulação de valor relativo à prestação de serviço de transporte','Classificam-se neste código as anulações correspondentes a valores faturados indevidamente, decorrentes de prestações de serviços de transporte.'),(234,3207,'Anulação de valor relativo à venda de energia elétrica','Classificam-se neste código as anulações correspondentes a valores faturados indevidamente, decorrentes de venda de energia elétrica.'),(235,3211,'Devolução de venda de produção do estabelecimento sob o regime de drawback ','Classificam-se neste código as devoluções de vendas de produtos industrializados pelo estabelecimento sob o regime de drawback.'),(236,3250,'COMPRAS DE ENERGIA ELÉTRICA',''),(237,3251,'Compra de energia elétrica para distribuição ou comercialização','Classificam-se neste código as compras de energia elétrica utilizada em sistema de distribuição ou comercialização. Também serão classificadas neste código as compras de energia elétrica por cooperativas para distribuição aos seus cooperados.'),(238,3300,'AQUISIÇÕES DE SERVIÇOS DE COMUNICAÇÃO',''),(239,3301,'Aquisição de serviço de comunicação para execução de serviço da mesma natureza','Classificam-se neste código as aquisições de serviços de comunicação utilizados nas prestações de serviços da mesma natureza.'),(240,3350,'AQUISIÇÕES DE SERVIÇOS DE TRANSPORTE',''),(241,3351,'Aquisição de serviço de transporte para execução de serviço da mesma natureza','Classificam-se neste código as aquisições de serviços de transporte utilizados nas prestações de serviços da mesma natureza.'),(242,3352,'Aquisição de serviço de transporte por estabelecimento industrial','Classificam-se neste código as aquisições de serviços de transporte utilizados por estabelecimento industrial. Também serão classificadas neste código as aquisições de serviços de transporte utilizados por estabelecimento industrial de cooperativa.'),(243,3353,'Aquisição de serviço de transporte por estabelecimento comercial','Classificam-se neste código as aquisições de serviços de transporte utilizados por estabelecimento comercial. Também serão classificadas neste código as aquisições de serviços de transporte utilizados por estabelecimento comercial de cooperativa.'),(244,3354,'Aquisição de serviço de transporte por estabelecimento de prestador de serviço de comunicação','Classificam-se neste código as aquisições de serviços de transporte utilizados por estabelecimento prestador de serviços de comunicação.'),(245,3355,'Aquisição de serviço de transporte por estabelecimento de geradora ou de distribuidora de energia elétrica','Classificam-se neste código as aquisições de serviços de transporte utilizados por estabelecimento de geradora ou de distribuidora de energia elétrica.'),(246,3356,'Aquisição de serviço de transporte por estabelecimento de produtor rural','Classificam-se neste código as aquisições de serviços de transporte utilizados por estabelecimento de produtor rural.'),(247,3500,'ENTRADAS DE MERCADORIAS REMETIDAS COM FIM ESPECÍFICO DE EXPORTAÇÃO E EVENTUAIS DEVOLUÇÕES',''),(248,3503,'Devolução de mercadoria exportada que tenha sido recebida com fim específico de exportação','Classificam-se neste código as devoluções de mercadorias exportadas por trading company, empresa comercial exportadora ou outro estabelecimento do remetente, recebidas com fim específico de exportação, cujas saídas tenham sido classificadas no código 7.501 - Exportação de mercadorias recebidas com fim específico de exportação.'),(249,3550,'OPERAÇÕES COM BENS DE ATIVO IMOBILIZADO E MATERIAIS PARA USO OU CONSUMO',''),(250,3551,'Compra de bem para o ativo imobilizado','Classificam-se neste código as compras de bens destinados ao ativo imobilizado do estabelecimento.'),(251,3553,'Devolução de venda de bem do ativo imobilizado','Classificam-se neste código as devoluções de vendas de bens do ativo imobilizado, cujas saídas tenham sido classificadas no código 7.551 - Venda de bem do ativo imobilizado.'),(252,3556,'Compra de material para uso ou consumo','Classificam-se neste código as compras de mercadorias destinadas ao uso ou consumo do estabelecimento.'),(253,3900,'OUTRAS ENTRADAS DE MERCADORIAS OU AQUISIÇÕES DE SERVIÇOS',''),(254,3930,'Lançamento efetuado a título de entrada de bem sob amparo de regime especial aduaneiro de admissão temporária','Classificam-se neste código os lançamentos efetuados a título de entrada de bens amparada por regime especial aduaneiro de admissão temporária.'),(255,3949,'Outra entrada de mercadoria ou prestação de serviço não especificado','Classificam-se neste código as outras entradas de mercadorias ou prestações de serviços que não tenham sido especificados nos códigos anteriores.'),(256,5000,'SAÍDAS OU PRESTAÇÕES DE SERVIÇOS PARA O ESTADO','Classificam-se, neste grupo, as operações ou prestações em que o estabelecimento remetente esteja localizado na mesma unidade da Federação do destinatário'),(257,5100,'VENDAS DE PRODUÇÃO PRÓPRIA OU DE TERCEIROS',''),(258,5101,'Venda de produção do estabelecimento','Classificam-se neste código as vendas de produtos industrializados no estabelecimento. Também serão classificadas neste código as vendas de mercadorias por estabelecimento industrial de cooperativa destinadas a seus cooperados ou a estabelecimento de outra cooperativa.'),(259,5102,'Venda de mercadoria adquirida ou recebida de terceiros','Classificam-se neste código as vendas de mercadorias adquiridas ou recebidas de terceiros para industrialização ou comercialização, que não tenham sido objeto de qualquer processo industrial no estabelecimento. Também serão classificadas neste código as vendas de mercadorias por estabelecimento comercial de cooperativa destinadas a seus cooperados ou estabelecimento de outra cooperativa.'),(260,5103,'Venda de produção do estabelecimento, efetuada fora do estabelecimento','Classificam-se neste código as vendas efetuadas fora do estabelecimento, inclusive por meio de veículo, de produtos industrializados no estabelecimento.'),(261,5104,'Venda de mercadoria adquirida ou recebida de terceiros, efetuada fora do estabelecimento','Classificam-se neste código as vendas efetuadas fora do estabelecimento, inclusive por meio de veículo, de mercadorias adquiridas ou recebidas de terceiros para industrialização ou comercialização, que não tenham sido objeto de qualquer processo industrial no estabelecimento.'),(262,5105,'Venda de produção do estabelecimento que não deva por ele transitar','Classificam-se neste código as vendas de produtos industrializados no estabelecimento, armazenados em depósito fechado, armazém geral ou outro sem que haja retorno ao estabelecimento depositante.'),(263,5106,'Venda de mercadoria adquirida ou recebida de terceiros, que não deva por ele transitar','Classificam-se neste código as vendas de mercadorias adquiridas ou recebidas de terceiros para industrialização ou comercialização, armazenadas em depósito fechado, armazém geral ou outro, que não tenham sido objeto de qualquer processo industrial no estabelecimento sem que haja retorno ao estabelecimento depositante. Também serão classificadas neste código as vendas de mercadorias importadas, cuja saída ocorra do recinto alfandegado ou da repartição alfandegária onde se processou o desembaraço aduaneiro, com destino ao estabelecimento do comprador, sem transitar pelo estabelecimento do importador.'),(264,5109,'Venda de produção do estabelecimento, destinada à Zona Franca de Manaus ou Áreas de Livre Comércio','Classificam-se neste código as vendas de produtos industrializados pelo estabelecimento, destinados à Zona Franca de Manaus ou Áreas de Livre Comércio.'),(265,5110,'Venda de mercadoria adquirida ou recebida de terceiros, destinada à Zona Franca de Manaus ou Áreas de Livre Comércio','Classificam-se neste código as vendas de mercadorias adquiridas ou recebidas de terceiros, que não tenham sido objeto de qualquer processo industrial no estabelecimento, destinadas à Zona Franca de Manaus ou Áreas de Livre Comércio.'),(266,5111,'Venda de produção do estabelecimento remetida anteriormente em consignação industrial','Classificam-se neste código as vendas efetivas de produtos industrializados no estabelecimento remetidos anteriormente a título de consignação industrial.'),(267,5112,'Venda de mercadoria adquirida ou recebida de terceiros remetida anteriormente em consignação industrial','Classificam-se neste código as vendas efetivas de mercadorias adquiridas ou recebidas de terceiros, que não tenham sido objeto de qualquer processo industrial no estabelecimento, remetidas anteriormente a título de consignação industrial.'),(268,5113,'Venda de produção do estabelecimento remetida anteriormente em consignação mercantil','Classificam-se neste código as vendas efetivas de produtos industrializados no estabelecimento remetidos anteriormente a título de consignação mercantil.'),(269,5114,'Venda de mercadoria adquirida ou recebida de terceiros remetida anteriormente em consignação mercantil','Classificam-se neste código as vendas efetivas de mercadorias adquiridas ou recebidas de terceiros, que não tenham sido objeto de qualquer processo industrial no estabelecimento, remetidas anteriormente a título de consignação mercantil.'),(270,5115,'Venda de mercadoria adquirida ou recebida de terceiros, recebida anteriormente em consignação mercantil','Classificam-se neste código as vendas de mercadorias adquiridas ou recebidas de terceiros, recebidas anteriormente a título de consignação mercantil.'),(271,5116,'Venda de produção do estabelecimento originada de encomenda para entrega futura','Classificam-se neste código as vendas de produtos industrializados pelo estabelecimento, quando da saída real do produto, cujo faturamento tenha sido classificado no código 5.922 - Lançamento efetuado a título de simples faturamento decorrente de venda para entrega futura.'),(272,5117,'Venda de mercadoria adquirida ou recebida de terceiros, originada de encomenda para entrega futura','Classificam-se neste código as vendas de mercadorias adquiridas ou recebidas de terceiros, que não tenham sido objeto de qualquer processo industrial no estabelecimento, quando da saída real da mercadoria, cujo faturamento tenha sido classificado no código 5.922 - Lançamento efetuado a título de simples faturamento decorrente de venda para entrega futura.'),(273,5118,'Venda de produção do estabelecimento entregue ao destinatário por conta e ordem do adquirente originário, em venda à ordem','Classificam-se neste código as vendas à ordem de produtos industrializados pelo estabelecimento, entregues ao destinatário por conta e ordem do adquirente originário.'),(274,5119,'Venda de mercadoria adquirida ou recebida de terceiros entregue ao destinatário por conta e ordem do adquirente originário, em venda à ordem','Classificam-se neste código as vendas à ordem de mercadorias adquiridas ou recebidas de terceiros, que não tenham sido objeto de qualquer processo industrial no estabelecimento, entregues ao destinatário por conta e ordem do adquirente originário.'),(275,5120,'Venda de mercadoria adquirida ou recebida de terceiros entregue ao destinatário pelo vendedor remetente, em venda à ordem','Classificam-se neste código as vendas à ordem de mercadorias adquiridas ou recebidas de terceiros, que não tenham sido objeto de qualquer processo industrial no estabelecimento, entregues pelo vendedor remetente ao destinatário, cuja compra seja classificada, pelo adquirente originário, no código 1.118 - Compra de mercadoria pelo adquirente originário, entregue pelo vendedor remetente ao destinatário, em venda à ordem.'),(276,5122,'Venda de produção do estabelecimento remetida para industrialização, por conta e ordem do adquirente, sem transitar pelo estabelecimento do adquirente','Classificam-se neste código as vendas de produtos industrializados no estabelecimento, remetidos para serem industrializados em outro estabelecimento, por conta e ordem do adquirente, sem que os produtos tenham transitado pelo estabelecimento do adquirente.'),(277,5123,'Venda de mercadoria adquirida ou recebida de terceiros remetida para industrialização, por conta e ordem do adquirente, sem transitar pelo estabelecimento do adquirente','Classificam-se neste código as vendas de mercadorias adquiridas ou recebidas de terceiros, que não tenham sido objeto de qualquer processo industrial no estabelecimento, remetidas para serem industrializadas em outro estabelecimento, por conta e ordem do adquirente, sem que as mercadorias tenham transitado pelo estabelecimento do adquirente.'),(278,5124,'Industrialização efetuada para outra empresa','Classificam-se neste código as saídas de mercadorias industrializadas para terceiros, compreendendo os valores referentes aos serviços prestados e os das mercadorias de propriedade do industrializador empregadas no processo industrial.'),(279,5125,'Industrialização efetuada para outra empresa quando a mercadoria recebida para utilização no processo de industrialização não transitar pelo estabelecimento adquirente da mercadoria','Classificam-se neste código as saídas de mercadorias industrializadas para outras empresas, em que as mercadorias recebidas para utilização no processo de industrialização não tenham transitado pelo estabelecimento do adquirente das mercadorias, compreendendo os valores referentes aos serviços prestados e os das mercadorias de propriedade do industrializador empregadas no processo industrial.'),(280,5150,'TRANSFERÊNCIAS DE PRODUÇÃO PRÓPRIA OU DE TERCEIROS',''),(281,5151,'Transferência de produção do estabelecimento','Classificam-se neste código os produtos industrializados no estabelecimento e transferidos para outro estabelecimento da mesma empresa.'),(282,5152,'Transferência de mercadoria adquirida ou recebida de terceiros','Classificam-se neste código as mercadorias adquiridas ou recebidas de terceiros para industrialização ou comercialização e que não tenham sido objeto de qualquer processo industrial no estabelecimento, transferidas para outro estabelecimento da mesma empresa.'),(283,5153,'Transferência de energia elétrica','Classificam-se neste código as transferências de energia elétrica para outro estabelecimento da mesma empresa, para distribuição.'),(284,5155,'Transferência de produção do estabelecimento, que não deva por ele transitar','Classificam-se neste código as transferências para outro estabelecimento da mesma empresa, de produtos industrializados no estabelecimento que tenham sido remetidos para armazém geral, depósito fechado ou outro, sem que haja retorno ao estabelecimento depositante.'),(285,5156,'Transferência de mercadoria adquirida ou recebida de terceiros, que não deva por ele transitar','Classificam-se neste código as transferências para outro estabelecimento da mesma empresa, de mercadorias adquiridas ou recebidas de terceiros para industrialização ou comercialização, que não tenham sido objeto de qualquer processo industrial, remetidas para armazém geral, depósito fechado ou outro, sem que haja retorno ao estabelecimento depositante.'),(286,5200,'DEVOLUÇÕES DE COMPRAS PARA INDUSTRIALIZAÇÃO, COMERCIALIZAÇÃO OU ANULAÇÕES DE VALORES',''),(287,5201,'Devolução de compra para industrialização','Classificam-se neste código as devoluções de mercadorias adquiridas para serem utilizadas em processo de industrialização, cujas entradas tenham sido classificadas como Compra para industrialização.'),(288,5202,'Devolução de compra para comercialização','Classificam-se neste código as devoluções de mercadorias adquiridas para serem comercializadas, cujas entradas tenham sido classificadas como Compra para comercialização.'),(289,5205,'Anulação de valor relativo a aquisição de serviço de comunicação','Classificam-se neste código as anulações correspondentes a valores faturados indevidamente, decorrentes das aquisições de serviços de comunicação.'),(290,5206,'Anulação de valor relativo a aquisição de serviço de transporte','Classificam-se neste código as anulações correspondentes a valores faturados indevidamente, decorrentes das aquisições de serviços de transporte.'),(291,5207,'Anulação de valor relativo à compra de energia elétrica','Classificam-se neste código as anulações correspondentes a valores faturados indevidamente, decorrentes da compra de energia elétrica.'),(292,5208,'Devolução de mercadoria recebida em transferência para industrialização','Classificam-se neste código as devoluções de mercadorias recebidas em transferência de outros estabelecimentos da mesma empresa, para serem utilizadas em processo de industrialização.'),(293,5209,'Devolução de mercadoria recebida em transferência para comercialização','Classificam-se neste código as devoluções de mercadorias recebidas em transferência de outro estabelecimento da mesma empresa, para serem comercializadas.'),(294,5210,'Devolução de compra para utilização na prestação de serviço','Classificam-se neste código as devoluções de mercadorias adquiridas para utilização na prestação de serviços, cujas entradas tenham sido classificadas no código 1.126 - Compra para utilização na prestação de serviço.'),(295,5250,'VENDAS DE ENERGIA ELÉTRICA',''),(296,5251,'Venda de energia elétrica para distribuição ou comercialização','Classificam-se neste código as vendas de energia elétrica destinada à distribuição ou comercialização. Também serão classificadas neste código as vendas de energia elétrica destinada a cooperativas para distribuição aos seus cooperados.'),(297,5252,'Venda de energia elétrica para estabelecimento industrial','Classificam-se neste código as vendas de energia elétrica para consumo por estabelecimento industrial. Também serão classificadas neste código as vendas de energia elétrica destinada a estabelecimento industrial de cooperativa.'),(298,5253,'Venda de energia elétrica para estabelecimento comercial','Classificam-se neste código as vendas de energia elétrica para consumo por estabelecimento comercial. Também serão classificadas neste código as vendas de energia elétrica destinada a estabelecimento comercial de cooperativa.'),(299,5254,'Venda de energia elétrica para estabelecimento prestador de serviço de transporte','Classificam-se neste código as vendas de energia elétrica para consumo por estabelecimento de prestador de serviços de transporte.'),(300,5255,'Venda de energia elétrica para estabelecimento prestador de serviço de comunicação','Classificam-se neste código as vendas de energia elétrica para consumo por estabelecimento de prestador de serviços de comunicação.'),(301,5256,'Venda de energia elétrica para estabelecimento de produtor rural','Classificam-se neste código as vendas de energia elétrica para consumo por estabelecimento de produtor rural.'),(302,5257,'Venda de energia elétrica para consumo por demanda contratada','Classificam-se neste código as vendas de energia elétrica para consumo por demanda contratada, que prevalecerá sobre os demais códigos deste subgrupo.'),(303,5258,'Venda de energia elétrica a não contribuinte','Classificam-se neste código as vendas de energia elétrica a pessoas físicas ou a pessoas jurídicas não indicadas nos códigos anteriores.'),(304,5300,'PRESTAÇÕES DE SERVIÇOS DE COMUNICAÇÃO',''),(305,5301,'Prestação de serviço de comunicação para execução de serviço da mesma natureza','Classificam-se neste código as prestações de serviços de comunicação destinados às prestações de serviços da mesma natureza.'),(306,5302,'Prestação de serviço de comunicação a estabelecimento industrial','Classificam-se neste código as prestações de serviços de comunicação a estabelecimento industrial. Também serão classificados neste código os serviços de comunicação prestados a estabelecimento industrial de cooperativa.'),(307,5303,'Prestação de serviço de comunicação a estabelecimento comercial','Classificam-se neste código as prestações de serviços de comunicação a estabelecimento comercial. Também serão classificados neste código os serviços de comunicação prestados a estabelecimento comercial de cooperativa.'),(308,5304,'Prestação de serviço de comunicação a estabelecimento de prestador de serviço de transporte','Classificam-se neste código as prestações de serviços de comunicação a estabelecimento prestador de serviço de transporte.'),(309,5305,'Prestação de serviço de comunicação a estabelecimento de geradora ou de distribuidora de energia elétrica','Classificam-se neste código as prestações de serviços de comunicação a estabelecimento de geradora ou de distribuidora de energia elétrica.'),(310,5306,'Prestação de serviço de comunicação a estabelecimento de produtor rural','Classificam-se neste código as prestações de serviços de comunicação a estabelecimento de produtor rural.'),(311,5307,'Prestação de serviço de comunicação a não contribuinte','Classificam-se neste código as prestações de serviços de comunicação a pessoas físicas ou a pessoas jurídicas não indicadas nos códigos anteriores.'),(312,5350,'PRESTAÇÕES DE SERVIÇOS DE TRANSPORTE',''),(313,5351,'Prestação de serviço de transporte para execução de serviço da mesma natureza','Classificam-se neste código as prestações de serviços de transporte destinados às prestações de serviços da mesma natureza.'),(314,5352,'Prestação de serviço de transporte a estabelecimento industrial','Classificam-se neste código as prestações de serviços de transporte a estabelecimento industrial. Também serão classificados neste código os serviços de transporte prestados a estabelecimento industrial de cooperativa.'),(315,5353,'Prestação de serviço de transporte a estabelecimento comercial','Classificam-se neste código as prestações de serviços de transporte a estabelecimento comercial. Também serão classificados neste código os serviços de transporte prestados a estabelecimento comercial de cooperativa.'),(316,5354,'Prestação de serviço de transporte a estabelecimento de prestador de serviço de comunicação','Classificam-se neste código as prestações de serviços de transporte a estabelecimento prestador de serviços de comunicação.'),(317,5355,'Prestação de serviço de transporte a estabelecimento de geradora ou de distribuidora de energia elétrica','Classificam-se neste código as prestações de serviços de transporte a estabelecimento de geradora ou de distribuidora de energia elétrica.'),(318,5356,'Prestação de serviço de transporte a estabelecimento de produtor rural','Classificam-se neste código as prestações de serviços de transporte a estabelecimento de produtor rural.'),(319,5357,'Prestação de serviço de transporte a não contribuinte','Classificam-se neste código as prestações de serviços de transporte a pessoas físicas ou a pessoas jurídicas não indicadas nos códigos anteriores.'),(320,5359,'Prestação de serviço de transporte a contribuinte ou a não contribuinte quando a mercadoria transportada está dispensada de emissão de nota fiscal. (ajuste sinief 03/04)','Classificam-se neste código as prestações de serviços de transporte a contribuintes ou a não contribuintes, exclusivamente quando não existe a obrigação legal de emissão de nota fiscal para a mercadoria transportada. \n'),(321,5400,'SAÍDAS DE MERCADORIAS SUJEITAS AO REGIME DE SUBSTITUIÇÃO TRIBUTÁRIA',''),(322,5401,'Venda de produção do estabelecimento em operação com produto sujeito ao regime de substituição tributária, na condição de contribuinte substituto','Classificam-se neste código as vendas de produtos industrializados no estabelecimento em operações com produtos sujeitos ao regime de substituição tributária, na condição de contribuinte substituto. Também serão classificadas neste código as vendas de produtos industrializados por estabelecimento industrial de cooperativa sujeitos ao regime de substituição tributária, na condição de contribuinte substituto.'),(323,5402,'Venda de produção do estabelecimento de produto sujeito ao regime de substituição tributária, em operação entre contribuintes substitutos do mesmo produto','Classificam-se neste código as vendas de produtos sujeitos ao regime de substituição tributária industrializados no estabelecimento, em operações entre contribuintes substitutos do mesmo produto'),(324,5403,'Venda de mercadoria, adquirida ou recebida de terceiros, sujeita ao regime de substituição tributária, na condição de contribuinte-substituto','Venda de mercadoria, adquirida ou recebida de terceiros, sujeita ao regime de substituição tributária, na condição de contribuinte-substituto.'),(325,5405,'Venda de mercadoria, adquirida ou recebida de terceiros, sujeita ao regime de substituição tributária, na condição de contribuinte-substituído','Venda de mercadoria, adquirida ou recebida de terceiros, sujeita ao regime de substituição tributária, na condição de contribuinte-substituído.'),(326,5408,'Transferência de produção do estabelecimento em operação com produto sujeito ao regime de substituição tributária','Classificam-se neste código os produtos industrializados no estabelecimento e transferidos para outro estabelecimento da mesma empresa, em operações com produtos sujeitos ao regime de substituição tributária.'),(327,5409,'Transferência de mercadoria adquirida ou recebida de terceiros em operação com mercadoria sujeita ao regime de substituição tributária','Classificam-se neste código as transferências para outro estabelecimento da mesma empresa, de mercadorias adquiridas ou recebidas de terceiros que não tenham sido objeto de qualquer processo industrial no estabelecimento, em operações com mercadorias sujeitas ao regime de substituição tributária.'),(328,5410,'Devolução de compra para industrialização em operação com mercadoria sujeita ao regime de substituição tributária','Classificam-se neste código as devoluções de mercadorias adquiridas para serem utilizadas em processo de industrialização cujas entradas tenham sido classificadas como Compra para industrialização em operação com mercadoria sujeita ao regime de substituição tributária.'),(329,5411,'Devolução de compra para comercialização em operação com mercadoria sujeita ao regime de substituição tributária','Classificam-se neste código as devoluções de mercadorias adquiridas para serem comercializadas, cujas entradas tenham sido classificadas como Compra para comercialização em operação com mercadoria sujeita ao regime de substituição tributária.'),(330,5412,'Devolução de bem do ativo imobilizado, em operação com mercadoria sujeita ao regime de substituição tributária','Classificam-se neste código as devoluções de bens adquiridos para integrar o ativo imobilizado do estabelecimento, cuja entrada tenha sido classificada no código 1.406 - Compra de bem para o ativo imobilizado cuja mercadoria está sujeita ao regime de substituição tributária.'),(331,5413,'Devolução de mercadoria destinada ao uso ou consumo, em operação com mercadoria sujeita ao regime de substituição tributária.','Classificam-se neste código as devoluções de mercadorias adquiridas para uso ou consumo do estabelecimento, cuja entrada tenha sido classificada no código 1.407 - Compra de mercadoria para uso ou consumo cuja mercadoria está sujeita ao regime de substituição tributária.'),(332,5414,'Remessa de produção do estabelecimento para venda fora do estabelecimento em operação com produto sujeito ao regime de substituição tributária','Classificam-se neste código as remessas de produtos industrializados pelo estabelecimento para serem vendidos fora do estabelecimento, inclusive por meio de veículos, em operações com produtos sujeitos ao regime de substituição tributária.'),(333,5415,'Remessa de mercadoria adquirida ou recebida de terceiros para venda fora do estabelecimento, em operação com mercadoria sujeita ao regime de substituição tributária','Classificam-se neste código as remessas de mercadorias adquiridas ou recebidas de terceiros para serem vendidas fora do estabelecimento, inclusive por meio de veículos, em operações com mercadorias sujeitas ao regime de substituição tributária.'),(334,5450,'SISTEMAS DE INTEGRAÇÃO',''),(335,5451,'Remessa de animal e de insumo para estabelecimento produtor','Classificam-se neste código as saídas referentes à remessa de animais e de insumos para criação de animais no sistema integrado, tais como: pintos, leitões, rações e medicamentos.'),(336,5500,'REMESSAS COM FIM ESPECÍFICO DE EXPORTAÇÃO E EVENTUAIS DEVOLUÇÕES',''),(337,5501,'Remessa de produção do estabelecimento, com fim específico de exportação','Classificam-se neste código as saídas de produtos industrializados pelo estabelecimento, remetidos com fim específico de exportação a trading company, empresa comercial exportadora ou outro estabelecimento do remetente.'),(338,5502,'Remessa de mercadoria adquirida ou recebida de terceiros, com fim específico de exportação','Classificam-se neste código as saídas de mercadorias adquiridas ou recebidas de terceiros, remetidas com fim específico de exportação a trading company, empresa comercial exportadora ou outro estabelecimento do remetente.'),(339,5503,'Devolução de mercadoria recebida com fim específico de exportação','Classificam-se neste código as devoluções efetuadas por trading company, empresa comercial exportadora ou outro estabelecimento do destinatário, de mercadorias recebidas com fim específico de exportação, cujas entradas tenham sido classificadas no código 1.501 - Entrada de mercadoria recebida com fim específico de exportação.'),(340,5550,'OPERAÇÕES COM BENS DE ATIVO IMOBILIZADO E MATERIAIS PARA USO OU CONSUMO',''),(341,5551,'Venda de bem do ativo imobilizado','Classificam-se neste código as vendas de bens integrantes do ativo imobilizado do estabelecimento.'),(342,5552,'Transferência de bem do ativo imobilizado','Classificam-se neste código os bens do ativo imobilizado transferidos para outro estabelecimento da mesma empresa.'),(343,5553,'Devolução de compra de bem para o ativo imobilizado','Classificam-se neste código as devoluções de bens adquiridos para integrar o ativo imobilizado do estabelecimento, cuja entrada foi classificada no código 1.551 - Compra de bem para o ativo imobilizado.'),(344,5554,'Remessa de bem do ativo imobilizado para uso fora do estabelecimento','Classificam-se neste código as remessas de bens do ativo imobilizado para uso fora do estabelecimento.'),(345,5555,'Devolução de bem do ativo imobilizado de terceiro, recebido para uso no estabelecimento','Classificam-se neste código as saídas em devolução, de bens do ativo imobilizado de terceiros, recebidos para uso no estabelecimento, cuja entrada tenha sido classificada no código 1.555 - Entrada de bem do ativo imobilizado de terceiro, remetido para uso no estabelecimento.'),(346,5556,'Devolução de compra de material de uso ou consumo','Classificam-se neste código as devoluções de mercadorias destinadas ao uso ou consumo do estabelecimento, cuja entrada tenha sido classificada no código 1.556 - Compra de material para uso ou consumo.'),(347,5557,'Transferência de material de uso ou consumo','Classificam-se neste código os materiais para uso ou consumo transferidos para outro estabelecimento da mesma empresa.'),(348,5600,'CRÉDITOS E RESSARCIMENTOS DE ICMS',''),(349,5601,'Transferência de crédito de ICMS acumulado','Classificam-se neste código os lançamentos destinados ao registro da transferência de créditos de ICMS para outras empresas.'),(350,5602,'Transferência de saldo credor de ICMS para outro estabelecimento da mesma empresa, destinado à compensação de saldo devedor de ICMS','Classificam-se neste código os lançamentos destinados ao registro da transferência de saldos credores de ICMS para outros estabelecimentos da mesma empresa, destinados à compensação do saldo devedor desses estabelecimentos.'),(351,5603,'Ressarcimento de ICMS retido por substituição tributária','Classificam-se neste código os lançamentos destinados ao registro de ressarcimento de ICMS retido por substituição tributária a contribuinte substituído, efetuado pelo contribuinte substituto, nas hipóteses previstas na legislação aplicável.'),(352,5605,'Transferência de saldo devedor de ICMS de outro estabelecimento da mesma empresa. (ajuste sinief 03/04)','Classificam-se neste código os lançamentos destinados ao registro da transferência de saldo devedor de ICMS para outro estabelecimento da mesma empresa, para efetivação da apuração centralizada do imposto.\n'),(353,5900,'OUTRAS SAÍDAS DE MERCADORIAS OU PRESTAÇÕES DE SERVIÇOS',''),(354,5901,'Remessa para industrialização por encomenda','Classificam-se neste código as remessas de insumos remetidos para industrialização por encomenda, a ser realizada em outra empresa ou em outro estabelecimento da mesma empresa.'),(355,5902,'Retorno de mercadoria utilizada na industrialização por encomenda','Classificam-se neste código as remessas, pelo estabelecimento industrializador, dos insumos recebidos para industrialização e incorporados ao produto final, por encomenda de outra empresa ou de outro estabelecimento da mesma empresa. O valor dos insumos nesta operação deverá ser igual ao valor dos insumos recebidos para industrialização.'),(356,5903,'Retorno de mercadoria recebida para industrialização e não aplicada no referido processo','Classificam-se neste código as remessas em devolução de insumos recebidos para industrialização e não aplicados no referido processo.'),(357,5904,'Remessa para venda fora do estabelecimento','Classificam-se neste código as remessas de mercadorias para venda fora do estabelecimento, inclusive por meio de veículos.'),(358,5905,'Remessa para depósito fechado ou armazém geral','Classificam-se neste código as remessas de mercadorias para depósito em depósito fechado ou armazém geral.'),(359,5906,'Retorno de mercadoria depositada em depósito fechado ou armazém geral','Classificam-se neste código os retornos de mercadorias depositadas em depósito fechado ou armazém geral ao estabelecimento depositante.'),(360,5907,'Retorno simbólico de mercadoria depositada em depósito fechado ou armazém geral','Classificam-se neste código os retornos simbólicos de mercadorias recebidas para depósito em depósito fechado ou armazém geral, quando as mercadorias depositadas tenham sido objeto de saída a qualquer título e que não devam retornar ao estabelecimento depositante.'),(361,5908,'Remessa de bem por conta de contrato de comodato','Classificam-se neste código as remessas de bens para o cumprimento de contrato de comodato.'),(362,5909,'Retorno de bem recebido por conta de contrato de comodato','Classificam-se neste código as remessas de bens em devolução após cumprido o contrato de comodato.'),(363,5910,'Remessa em bonificação, doação ou brinde','Classificam-se neste código as remessas de mercadorias a título de bonificação, doação ou brinde.'),(364,5911,'Remessa de amostra grátis','Classificam-se neste código as remessas de mercadorias a título de amostra grátis.'),(365,5912,'Remessa de mercadoria ou bem para demonstração','Classificam-se neste código as remessas de mercadorias ou bens para demonstração.'),(366,5913,'Retorno de mercadoria ou bem recebido para demonstração','Classificam-se neste código as remessas em devolução de mercadorias ou bens recebidos para demonstração.'),(367,5914,'Remessa de mercadoria ou bem para exposição ou feira','Classificam-se neste código as remessas de mercadorias ou bens para exposição ou feira.'),(368,5915,'Remessa de mercadoria ou bem para conserto ou reparo','Classificam-se neste código as remessas de mercadorias ou bens para conserto ou reparo.'),(369,5916,'Retorno de mercadoria ou bem recebido para conserto ou reparo','Classificam-se neste código as remessas em devolução de mercadorias ou bens recebidos para conserto ou reparo.'),(370,5917,'Remessa de mercadoria em consignação mercantil ou industrial','Classificam-se neste código as remessas de mercadorias a título de consignação mercantil ou industrial.'),(371,5918,'Devolução de mercadoria recebida em consignação mercantil ou industrial','Classificam-se neste código as devoluções de mercadorias recebidas anteriormente a título de consignação mercantil ou industrial.'),(372,5919,'Devolução simbólica de mercadoria vendida ou utilizada em processo industrial, recebida anteriormente em consignação mercantil ou industrial','Classificam-se neste código as devoluções simbólicas de mercadorias vendidas ou utilizadas em processo industrial, que tenham sido recebidas anteriormente a título de consignação mercantil ou industrial.'),(373,5920,'Remessa de vasilhame ou sacaria','Classificam-se neste código as remessas de vasilhame ou sacaria.'),(374,5921,'Devolução de vasilhame ou sacaria','Classificam-se neste código as saídas por devolução de vasilhame ou sacaria.'),(375,5922,'Lançamento efetuado a título de simples faturamento decorrente de venda para entrega futura','Classificam-se neste código os registros efetuados a título de simples faturamento decorrente de venda para entrega futura.'),(376,5923,'Remessa de mercadoria por conta e ordem de terceiros, em venda à ordem','Classificam-se neste código as saídas correspondentes à entrega de mercadorias por conta e ordem de terceiros, em vendas à ordem, cuja venda ao adquirente originário, foi classificada nos códigos 5.118 - Venda de produção do estabelecimento entregue ao destinatário por conta e ordem do adquirente originário, em venda à ordem ou 5.119'),(377,5924,'Remessa para industrialização por conta e ordem do adquirente da mercadoria, quando esta não transitar pelo estabelecimento do adquirente','Classificam-se neste código as saídas de insumos com destino a estabelecimento industrializador, para serem industrializados por conta e ordem do adquirente, nas hipóteses em que os insumos não tenham transitado pelo estabelecimento do adquirente dos mesmos.'),(378,5925,'Retorno de mercadoria recebida para industrialização por conta e ordem do adquirente da mercadoria, quando aquela não transitar pelo estabelecimento do adquirente','Classificam-se neste código as remessas, pelo estabelecimento industrializador, dos insumos recebidos, por conta e ordem do adquirente, para industrialização e incorporados ao produto final, nas hipóteses em que os insumos não tenham transitado pelo estabelecimento do adquirente. O valor dos insumos nesta operação deverá ser igual ao valor dos insumos recebidos para industrialização.'),(379,5926,'Lançamento efetuado a título de reclassificação de mercadoria decorrente de formação de kit ou de sua desagregação','Classificam-se neste código os registros efetuados a título de reclassificação decorrente de formação de kit de mercadorias ou de sua desagregação.'),(380,5927,'Lançamento efetuado a título de baixa de estoque decorrente de perda, roubo ou deterioração','Classificam-se neste código os registros efetuados a título de baixa de estoque decorrente de perda, roubou ou deterioração das mercadorias.'),(381,5928,'Lançamento efetuado a título de baixa de estoque decorrente do encerramento da atividade da empresa','Classificam-se neste código os registros efetuados a título de baixa de estoque decorrente do encerramento das atividades da empresa.'),(382,5929,'Lançamento efetuado em decorrência de emissão de documento fiscal relativo a operação ou prestação também registrada em equipamento Emissor de Cupom Fiscal - ECF','Classificam-se neste código os registros relativos aos documentos fiscais emitidos em operações ou prestações que também tenham sido registradas em equipamento Emissor de Cupom Fiscal - ECF.'),(383,5931,'Lançamento efetuado em decorrência da responsabilidade de retenção do imposto por substituição tributária, atribuída ao remetente ou alienante da mercadoria, pelo serviço de transporte realizado por transportador autônomo ou por transportador não inscrito na unidade da Federação onde iniciado o serviço','Classificam-se neste código exclusivamente os lançamentos efetuados pelo remetente ou alienante da mercadoria quando lhe for atribuída a responsabilidade pelo recolhimento do imposto devido pelo serviço de transporte realizado por transportador autônomo ou por transportador não inscrito na unidade da Federação onde iniciado o serviço.'),(384,5932,'Prestação de serviço de transporte iniciada em unidade da Federação diversa daquela onde inscrito o prestador','Classificam-se neste código as prestações de serviço de transporte que tenham sido iniciadas em unidade da Federação diversa daquela onde o prestador está inscrito como contribuinte.'),(385,5933,'Prestação de serviço tributado pelo ISSQN. (ajuste sinief 03/04)','Classificam-se neste código as prestações de serviços, de competência municipal, desde que informados em documentos autorizados pelo Estado.'),(386,5949,'Outra saída de mercadoria ou prestação de serviço não especificado','Classificam-se neste código as outras saídas de mercadorias ou prestações de serviços que não tenham sido especificados nos códigos anteriores.'),(387,6000,'SAÍDAS OU PRESTAÇÕES DE SERVIÇOS PARA OUTROS ESTADOS','Classificam-se, neste grupo, as operações ou prestações em que o estabelecimento remetente esteja localizado em unidade da Federação diversa daquela do destinatário'),(388,6100,'VENDAS DE PRODUÇÃO PRÓPRIA OU DE TERCEIROS',''),(389,6101,'Venda de produção do estabelecimento','Classificam-se neste código as vendas de produtos industrializados no estabelecimento. Também serão classificadas neste código as vendas de mercadorias por estabelecimento industrial de cooperativa destinadas a seus cooperados ou a estabelecimento de outra cooperativa.'),(390,6102,'Venda de mercadoria adquirida ou recebida de terceiros','Classificam-se neste código as vendas de mercadorias adquiridas ou recebidas de terceiros para industrialização ou comercialização, que não tenham sido objeto de qualquer processo industrial no estabelecimento. Também serão classificadas neste código as vendas de mercadorias por estabelecimento comercial de cooperativa destinadas a seus cooperados ou estabelecimento de outra cooperativa.'),(391,6103,'Venda de produção do estabelecimento, efetuada fora do estabelecimento','Classificam-se neste código as vendas efetuadas fora do estabelecimento, inclusive por meio de veículo, de produtos industrializados no estabelecimento.'),(392,6104,'Venda de mercadoria adquirida ou recebida de terceiros, efetuada fora do estabelecimento','Classificam-se neste código as vendas efetuadas fora do estabelecimento, inclusive por meio de veículo, de mercadorias adquiridas ou recebidas de terceiros para industrialização ou comercialização, que não tenham sido objeto de qualquer processo industrial no estabelecimento.'),(393,6105,'Venda de produção do estabelecimento que não deva por ele transitar','Classificam-se neste código as vendas de produtos industrializados no estabelecimento, armazenados em depósito fechado, armazém geral ou outro sem que haja retorno ao estabelecimento depositante.'),(394,6106,'Venda de mercadoria adquirida ou recebida de terceiros, que não deva por ele transitar','Classificam-se neste código as vendas de mercadorias adquiridas ou recebidas de terceiros para industrialização ou comercialização, armazenadas em depósito fechado, armazém geral ou outro, que não tenham sido objeto de qualquer processo industrial no estabelecimento sem que haja retorno ao estabelecimento depositante. Também serão classificadas neste código as vendas de mercadorias importadas, cuja saída ocorra do recinto alfandegado ou da repartição alfandegária onde se processou o desembaraço aduaneiro, com destino ao estabelecimento do comprador, sem transitar pelo estabelecimento do importador.'),(395,6107,'Venda de produção do estabelecimento, destinada a não contribuinte','Classificam-se neste código as vendas de produtos industrializados no estabelecimento, destinadas a não contribuintes. Quaisquer operações de venda destinadas a não contribuintes deverão ser classificadas neste código.'),(396,6108,'Venda de mercadoria adquirida ou recebida de terceiros, destinada a não contribuinte','Classificam-se neste código as vendas de mercadorias adquiridas ou recebidas de terceiros para industrialização ou comercialização, que não tenham sido objeto de qualquer processo industrial no estabelecimento, destinadas a não contribuintes. Quaisquer operações de venda destinadas a não contribuintes deverão ser classificadas neste código.'),(397,6109,'Venda de produção do estabelecimento, destinada à Zona Franca de Manaus ou Áreas de Livre Comércio','Classificam-se neste código as vendas de produtos industrializados pelo estabelecimento, destinados à Zona Franca de Manaus ou Áreas de Livre Comércio.'),(398,6110,'Venda de mercadoria adquirida ou recebida de terceiros, destinada à Zona Franca de Manaus ou Áreas de Livre Comércio','Classificam-se neste código as vendas de mercadorias adquiridas ou recebidas de terceiros, que não tenham sido objeto de qualquer processo industrial no estabelecimento, destinadas à Zona Franca de Manaus ou Áreas de Livre Comércio.'),(399,6111,'Venda de produção do estabelecimento remetida anteriormente em consignação industrial','Classificam-se neste código as vendas efetivas de produtos industrializados no estabelecimento remetidos anteriormente a título de consignação industrial.'),(400,6112,'Venda de mercadoria adquirida ou recebida de Terceiros remetida anteriormente em consignação industrial','Classificam-se neste código as vendas efetivas de mercadorias adquiridas ou recebidas de terceiros, que não tenham sido objeto de qualquer processo industrial no estabelecimento, remetidas anteriormente a título de consignação industrial.'),(401,6113,'Venda de produção do estabelecimento remetida anteriormente em consignação mercantil','Classificam-se neste código as vendas efetivas de produtos industrializados no estabelecimento remetidos anteriormente a título de consignação mercantil.'),(402,6114,'Venda de mercadoria adquirida ou recebida de terceiros remetida anteriormente em consignação mercantil','Classificam-se neste código as vendas efetivas de mercadorias adquiridas ou recebidas de terceiros, que não tenham sido objeto de qualquer processo industrial no estabelecimento, remetidas anteriormente a título de consignação mercantil.'),(403,6115,'Venda de mercadoria adquirida ou recebida de terceiros, recebida anteriormente em consignação mercantil','Classificam-se neste código as vendas de mercadorias adquiridas ou recebidas de terceiros, recebidas anteriormente a título de consignação mercantil.'),(404,6116,'Venda de produção do estabelecimento originada de encomenda para entrega futura','Classificam-se neste código as vendas de produtos industrializados pelo estabelecimento, quando da saída real do produto, cujo faturamento tenha sido classificado no código 6.922 - Lançamento efetuado a título de simples faturamento decorrente de venda para entrega futura.'),(405,6117,'Venda de mercadoria adquirida ou recebida de terceiros, originada de encomenda para entrega futura','Classificam-se neste código as vendas de mercadorias adquiridas ou recebidas de terceiros, que não tenham sido objeto de qualquer processo industrial no estabelecimento, quando da saída real da mercadoria, cujo faturamento tenha sido classificado no código 6.922 - Lançamento efetuado a título de simples faturamento decorrente de venda para entrega futura.'),(406,6118,'Venda de produção do estabelecimento entregue ao destinatário por conta e ordem do adquirente originário, em venda à ordem','Classificam-se neste código as vendas à ordem de produtos industrializados pelo estabelecimento, entregues ao destinatário por conta e ordem do adquirente originário.'),(407,6119,'Venda de mercadoria adquirida ou recebida de terceiros entregue ao destinatário por conta e ordem do adquirente originário, em venda à ordem','Classificam-se neste código as vendas à ordem de mercadorias adquiridas ou recebidas de terceiros, que não tenham sido objeto de qualquer processo industrial no estabelecimento, entregues ao destinatário por conta e ordem do adquirente originário.'),(408,6120,'Venda de mercadoria adquirida ou recebida de terceiros entregue ao destinatário pelo vendedor remetente, em venda à ordem','Classificam-se neste código as vendas à ordem de mercadorias adquiridas ou recebidas de terceiros, que não tenham sido objeto de qualquer processo industrial no estabelecimento, entregues pelo vendedor remetente ao destinatário, cuja compra seja classificada, pelo adquirente originário, no código 2.118 - Compra de mercadoria pelo adquirente originário, entregue pelo vendedor remetente ao destinatário, em venda à ordem.'),(409,6122,'Venda de produção do estabelecimento remetida para industrialização, por conta e ordem do adquirente, sem transitar pelo estabelecimento do adquirente','Classificam-se neste código as vendas de produtos industrializados no estabelecimento, remetidos para serem industrializados em outro estabelecimento, por conta e ordem do adquirente, sem que os produtos tenham transitado pelo estabelecimento do adquirente.'),(410,6123,'Venda de mercadoria adquirida ou recebida de terceiros remetida para industrialização, por conta e ordem do adquirente, sem transitar pelo estabelecimento do adquirente','Classificam-se neste código as vendas de mercadorias adquiridas ou recebidas de terceiros, que não tenham sido objeto de qualquer processo industrial no estabelecimento, remetidas para serem industrializadas em outro estabelecimento, por conta e ordem do adquirente, sem que as mercadorias tenham transitado pelo estabelecimento do adquirente.'),(411,6124,'Industrialização efetuada para outra empresa','Classificam-se neste código as saídas de mercadorias industrializadas para terceiros, compreendendo os valores referentes aos serviços prestados e os das mercadorias de propriedade do industrializador empregadas no processo industrial.'),(412,6125,'Industrialização efetuada para outra empresa quando a mercadoria recebida para utilização no processo de industrialização não transitar pelo estabelecimento adquirente da mercadoria','Classificam-se neste código as saídas de mercadorias industrializadas para outras empresas, em que as mercadorias recebidas para utilização no processo de industrialização não tenham transitado pelo estabelecimento do adquirente das mercadorias, compreendendo os valores referentes aos serviços prestados e os das mercadorias de propriedade do industrializador empregadas no processo industrial.'),(413,6150,'TRANSFERÊNCIAS DE PRODUÇÃO PRÓPRIA OU DE TERCEIROS',''),(414,6151,'Transferência de produção do estabelecimento','Classificam-se neste código os produtos industrializados no estabelecimento e transferidos para outro estabelecimento da mesma empresa.'),(415,6152,'Transferência de mercadoria adquirida ou recebida de terceiros','Classificam-se neste código as mercadorias adquiridas ou recebidas de terceiros para industrialização ou comercialização e que não tenham sido objeto de qualquer processo industrial no estabelecimento, transferidas para outro estabelecimento da mesma empresa.'),(416,6153,'Transferência de energia elétrica','Classificam-se neste código as transferências de energia elétrica para outro estabelecimento da mesma empresa, para distribuição.'),(417,6155,'Transferência de produção do estabelecimento, que não deva por ele transitar','Classificam-se neste código as transferências para outro estabelecimento da mesma empresa, de produtos industrializados no estabelecimento que tenham sido remetidos para armazém geral, depósito fechado ou outro, sem que haja retorno ao estabelecimento depositante.'),(418,6156,'Transferência de mercadoria adquirida ou recebida de terceiros, que não deva por ele transitar','Classificam-se neste código as transferências para outro estabelecimento da mesma empresa, de mercadorias adquiridas ou recebidas de terceiros para industrialização ou comercialização, que não tenham sido objeto de qualquer processo industrial, remetidas para armazém geral, depósito fechado ou outro, sem que haja retorno ao estabelecimento depositante.'),(419,6200,'DEVOLUÇÕES DE COMPRAS PARA INDUSTRIALIZAÇÃO, COMERCIALIZAÇÃO OU ANULAÇÕES DE VALORES',''),(420,6201,'Devolução de compra para industrialização','Classificam-se neste código as devoluções de mercadorias adquiridas para serem utilizadas em processo de industrialização, cujas entradas tenham sido classificadas como Compra para industrialização.'),(421,6202,'Devolução de compra para comercialização','Classificam-se neste código as devoluções de mercadorias adquiridas para serem comercializadas, cujas entradas tenham sido classificadas como Compra para comercialização.'),(422,6205,'Anulação de valor relativo a aquisição de serviço de comunicação','Classificam-se neste código as anulações correspondentes a valores faturados indevidamente, decorrentes das aquisições de serviços de comunicação.'),(423,6206,'Anulação de valor relativo a aquisição de serviço de transporte','Classificam-se neste código as anulações correspondentes a valores faturados indevidamente, decorrentes das aquisições de serviços de transporte.'),(424,6207,'Anulação de valor relativo à compra de energia elétrica','Classificam-se neste código as anulações correspondentes a valores faturados indevidamente, decorrentes da compra de energia elétrica.'),(425,6208,'Devolução de mercadoria recebida em transferência para industrialização','Classificam-se neste código as devoluções de mercadorias recebidas em transferência de outros estabelecimentos da mesma empresa, para serem utilizadas em processo de industrialização.'),(426,6209,'Devolução de mercadoria recebida em transferência para comercialização','Classificam-se neste código as devoluções de mercadorias recebidas em transferência de outro estabelecimento da mesma empresa, para serem comercializadas.'),(427,6210,'Devolução de compra para utilização na prestação de serviço','Classificam-se neste código as devoluções de mercadorias adquiridas para utilização na prestação de serviços, cujas entradas tenham sido classificadas no código 2.126 - Compra para utilização na prestação de serviço.'),(428,6250,'VENDAS DE ENERGIA ELÉTRICA',''),(429,6251,'Venda de energia elétrica para distribuição ou comercialização','Classificam-se neste código as vendas de energia elétrica destinada à distribuição ou comercialização. Também serão classificadas neste código as vendas de energia elétrica destinada a cooperativas para distribuição aos seus cooperados.'),(430,6252,'Venda de energia elétrica para estabelecimento industrial','Classificam-se neste código as vendas de energia elétrica para consumo por estabelecimento industrial. Também serão classificadas neste código as vendas de energia elétrica destinada a estabelecimento industrial de cooperativa.'),(431,6253,'Venda de energia elétrica para estabelecimento comercial','Classificam-se neste código as vendas de energia elétrica para consumo por estabelecimento comercial. Também serão classificadas neste código as vendas de energia elétrica destinada a estabelecimento comercial de cooperativa.'),(432,6254,'Venda de energia elétrica para estabelecimento prestador de serviço de transporte','Classificam-se neste código as vendas de energia elétrica para consumo por estabelecimento de prestador de serviços de transporte.'),(433,6255,'Venda de energia elétrica para estabelecimento prestador de serviço de comunicação','Classificam-se neste código as vendas de energia elétrica para consumo por estabelecimento de prestador de serviços de comunicação.'),(434,6256,'Venda de energia elétrica para estabelecimento de produtor rural','Classificam-se neste código as vendas de energia elétrica para consumo por estabelecimento de produtor rural.'),(435,6257,'Venda de energia elétrica para consumo por demanda contratada','Classificam-se neste código as vendas de energia elétrica para consumo por demanda contratada, que prevalecerá sobre os demais códigos deste subgrupo.'),(436,6258,'Venda de energia elétrica a não contribuinte','Classificam-se neste código as vendas de energia elétrica a pessoas físicas ou a pessoas jurídicas não indicadas nos códigos anteriores.'),(437,6300,'PRESTAÇÕES DE SERVIÇOS DE COMUNICAÇÃO',''),(438,6301,'Prestação de serviço de comunicação para execução de serviço da mesma natureza','Classificam-se neste código as prestações de serviços de comunicação destinados às prestações de serviços da mesma natureza.'),(439,6302,'Prestação de serviço de comunicação a estabelecimento industrial','Classificam-se neste código as prestações de serviços de comunicação a estabelecimento industrial. Também serão classificados neste código os serviços de comunicação prestados a estabelecimento industrial de cooperativa.'),(440,6303,'Prestação de serviço de comunicação a estabelecimento comercial','Classificam-se neste código as prestações de serviços de comunicação a estabelecimento comercial. Também serão classificados neste código os serviços de comunicação prestados a estabelecimento comercial de cooperativa.'),(441,6304,'Prestação de serviço de comunicação a estabelecimento de prestador de serviço de transporte','Classificam-se neste código as prestações de serviços de comunicação a estabelecimento prestador de serviço de transporte.'),(442,6305,'Prestação de serviço de comunicação a estabelecimento de geradora ou de distribuidora de energia elétrica','Classificam-se neste código as prestações de serviços de comunicação a estabelecimento de geradora ou de distribuidora de energia elétrica.'),(443,6306,'Prestação de serviço de comunicação a estabelecimento de produtor rural','Classificam-se neste código as prestações de serviços de comunicação a estabelecimento de produtor rural.'),(444,6307,'Prestação de serviço de comunicação a não contribuinte','Classificam-se neste código as prestações de serviços de comunicação a pessoas físicas ou a pessoas jurídicas não indicadas nos códigos anteriores.'),(445,6350,'PRESTAÇÕES DE SERVIÇOS DE TRANSPORTE',''),(446,6351,'Prestação de serviço de transporte para execução de serviço da mesma natureza','Classificam-se neste código as prestações de serviços de transporte destinados às prestações de serviços da mesma natureza.'),(447,6352,'Prestação de serviço de transporte a estabelecimento industrial','Classificam-se neste código as prestações de serviços de transporte a estabelecimento industrial. Também serão classificados neste código os serviços de transporte prestados a estabelecimento industrial de cooperativa.'),(448,6353,'Prestação de serviço de transporte a estabelecimento comercial','Classificam-se neste código as prestações de serviços de transporte a estabelecimento comercial. Também serão classificados neste código os serviços de transporte prestados a estabelecimento comercial de cooperativa.'),(449,6354,'Prestação de serviço de transporte a estabelecimento de prestador de serviço de comunicação','Classificam-se neste código as prestações de serviços de transporte a estabelecimento prestador de serviços de comunicação.'),(450,6355,'Prestação de serviço de transporte a estabelecimento de geradora ou de distribuidora de energia elétrica','Classificam-se neste código as prestações de serviços de transporte a estabelecimento de geradora ou de distribuidora de energia elétrica.'),(451,6356,'Prestação de serviço de transporte a estabelecimento de produtor rural','Classificam-se neste código as prestações de serviços de transporte a estabelecimento de produtor rural.'),(452,6357,'Prestação de serviço de transporte a não contribuinte','Classificam-se neste código as prestações de serviços de transporte a pessoas físicas ou a pessoas jurídicas não indicadas nos códigos anteriores.'),(453,6359,'Prestação de serviço de transporte a contribuinte ou a não contribuinte quando a mercadoria transportada está dispensada de emissão de nota fiscal. (ajuste sinief 03/04)','Classificam-se neste código as prestações de serviços de transporte a contribuintes ou a não contribuintes, exclusivamente quando não existe a obrigação legal de emissão de nota fiscal para a mercadoria transportada. \n'),(454,6400,'SAÍDAS DE MERCADORIAS SUJEITAS AO REGIME DE SUBSTITUIÇÃO TRIBUTÁRIA',''),(455,6401,'Venda de produção do estabelecimento em operação com produto sujeito ao regime de substituição tributária, na condição de contribuinte substituto','Classificam-se neste código as vendas de produtos industrializados no estabelecimento em operações com produtos sujeitos ao regime de substituição tributária, na condição de contribuinte substituto. Também serão classificadas neste código as vendas de produtos industrializados por estabelecimento industrial de cooperativa sujeitos ao regime de substituição tributária, na condição de contribuinte substituto.'),(456,6402,'Venda de produção do estabelecimento de produto sujeito ao regime de substituição tributária, em operação entre contribuintes substitutos do mesmo produto','Classificam-se neste código as vendas de produtos sujeitos ao regime de substituição tributária industrializados no estabelecimento, em operações entre contribuintes substitutos do mesmo produto.'),(457,6403,'Venda de mercadoria adquirida ou recebida de terceiros em operação com mercadoria sujeita ao regime de substituição tributária, na condição de contribuinte substituto','Classificam-se neste código as vendas de mercadorias adquiridas ou recebidas de terceiros, na condição de contribuinte substituto, em operação com mercadorias sujeitas ao regime de substituição tributária.'),(458,6404,'Venda de mercadoria sujeita ao regime de substituição tributária, cujo imposto já tenha sido retido anteriormente','Classificam-se neste código as vendas de mercadorias sujeitas ao regime de substituição tributária, na condição de substituto tributário, exclusivamente nas hipóteses em que o imposto já tenha sido retido anteriormente.'),(459,6408,'Transferência de produção do estabelecimento em operação com produto sujeito ao regime de substituição tributária','Classificam-se neste código os produtos industrializados no estabelecimento e transferidos para outro estabelecimento da mesma empresa, em operações com produtos sujeitos ao regime de substituição tributária.'),(460,6409,'Transferência de mercadoria adquirida ou recebida de terceiros em operação com mercadoria sujeita ao regime de substituição tributária','Classificam-se neste código as transferências para outro estabelecimento da mesma empresa, de mercadorias adquiridas ou recebidas de terceiros que não tenham sido objeto de qualquer processo industrial no estabelecimento, em operações com mercadorias sujeitas ao regime de substituição tributária.'),(461,6410,'Devolução de compra para industrialização em operação com mercadoria sujeita ao regime de substituição tributária','Classificam-se neste código as devoluções de mercadorias adquiridas para serem utilizadas em processo de industrialização cujas entradas tenham sido classificadas como Compra para industrialização em operação com mercadoria sujeita ao regime de substituição tributária.'),(462,6411,'Devolução de compra para comercialização em operação com mercadoria sujeita ao regime de substituição tributária','Classificam-se neste código as devoluções de mercadorias adquiridas para serem comercializadas, cujas entradas tenham sido classificadas como Compra para comercialização em operação com mercadoria sujeita ao regime de substituição tributária.'),(463,6412,'Devolução de bem do ativo imobilizado, em operação com mercadoria sujeita ao regime de substituição tributária','Classificam-se neste código as devoluções de bens adquiridos para integrar o ativo imobilizado do estabelecimento, cuja entrada tenha sido classificada no código 2.406 - Compra de bem para o ativo imobilizado cuja mercadoria está sujeita ao regime de substituição tributária.'),(464,6413,'Devolução de mercadoria destinada ao uso ou consumo, em operação com mercadoria sujeita ao regime de substituição tributária','Classificam-se neste código as devoluções de mercadorias adquiridas para uso ou consumo do estabelecimento, cuja entrada tenha sido classificada no código 2.407 - Compra de mercadoria para uso ou consumo cuja mercadoria está sujeita ao regime de substituição tributária.'),(465,6414,'Remessa de produção do estabelecimento para venda fora do estabelecimento em operação com produto sujeito ao regime de substituição tributária','Classificam-se neste código as remessas de produtos industrializados pelo estabelecimento para serem vendidos fora do estabelecimento, inclusive por meio de veículos, em operações com produtos sujeitos ao regime de substituição tributária.'),(466,6415,'Remessa de mercadoria adquirida ou recebida de terceiros para venda fora do estabelecimento, em operação com mercadoria sujeita ao regime de substituição tributária','Classificam-se neste código as remessas de mercadorias adquiridas ou recebidas de terceiros para serem vendidas fora do estabelecimento, inclusive por meio de veículos, em operações com mercadorias sujeitas ao regime de substituição tributária.'),(467,6500,'REMESSAS COM FIM ESPECÍFICO DE EXPORTAÇÃO E EVENTUAIS DEVOLUÇÕES',''),(468,6501,'Remessa de produção do estabelecimento, com fim específico de exportação','Classificam-se neste código as saídas de produtos industrializados pelo estabelecimento, remetidos com fim específico de exportação a trading company, empresa comercial exportadora ou outro estabelecimento do remetente.'),(469,6502,'Remessa de mercadoria adquirida ou recebida de terceiros, com fim específico de exportação','Classificam-se neste código as saídas de mercadorias adquiridas ou recebidas de terceiros, remetidas com fim específico de exportação a trading company, empresa comercial exportadora ou outro estabelecimento do remetente.'),(470,6503,'Devolução de mercadoria recebida com fim específico de exportação','Classificam-se neste código as devoluções efetuadas por trading company, empresa comercial exportadora ou outro estabelecimento do destinatário, de mercadorias recebidas com fim específico de exportação, cujas entradas tenham sido classificadas no código 2.501 - Entrada de mercadoria recebida com fim específico de exportação.'),(471,6550,'OPERAÇÕES COM BENS DE ATIVO IMOBILIZADO E MATERIAIS PARA USO OU CONSUMO',''),(472,6551,'Venda de bem do ativo imobilizado','Classificam-se neste código as vendas de bens integrantes do ativo imobilizado do estabelecimento.'),(473,6552,'Transferência de bem do ativo imobilizado','Classificam-se neste código os bens do ativo imobilizado transferidos para outro estabelecimento da mesma empresa.'),(474,6553,'Devolução de compra de bem para o ativo imobilizado','Classificam-se neste código as devoluções de bens adquiridos para integrar o ativo imobilizado do estabelecimento, cuja entrada foi classificada no código 2.551 - Compra de bem para o ativo imobilizado.'),(475,6554,'Remessa de bem do ativo imobilizado para uso fora do estabelecimento','Classificam-se neste código as remessas de bens do ativo imobilizado para uso fora do estabelecimento.'),(476,6555,'Devolução de bem do ativo imobilizado de terceiro, recebido para uso no estabelecimento','Classificam-se neste código as saídas em devolução, de bens do ativo imobilizado de terceiros, recebidos para uso no estabelecimento, cuja entrada tenha sido classificada no código 2.555 - Entrada de bem do ativo imobilizado de terceiro, remetido para uso no estabelecimento.'),(477,6556,'Devolução de compra de material de uso ou consumo','Classificam-se neste código as devoluções de mercadorias destinadas ao uso ou consumo do estabelecimento, cuja entrada tenha sido classificada no código 2.556'),(478,6557,'Transferência de material de uso ou consumo','Classificam-se neste código os materiais de uso ou consumo transferidos para outro estabelecimento da mesma empresa.'),(479,6600,'CRÉDITOS E RESSARCIMENTOS DE ICMS',''),(480,6603,'Ressarcimento de ICMS retido por substituição tributária','Classificam-se neste código os lançamentos destinados ao registro de ressarcimento de ICMS retido por substituição tributária a contribuinte substituído, efetuado pelo contribuinte substituto, nas hipóteses previstas na legislação aplicável.'),(481,6900,'OUTRAS SAÍDAS DE MERCADORIAS OU PRESTAÇÕES DE SERVIÇOS',''),(482,6901,'Remessa para industrialização por encomenda','Classificam-se neste código as remessas de insumos remetidos para industrialização por encomenda, a ser realizada em outra empresa ou em outro estabelecimento da mesma empresa.'),(483,6902,'Retorno de mercadoria utilizada na industrialização por encomenda','Classificam-se neste código as remessas, pelo estabelecimento industrializador, dos insumos recebidos para industrialização e incorporados ao produto final, por encomenda de outra empresa ou de outro estabelecimento da mesma empresa. O valor dos insumos nesta operação deverá ser igual ao valor dos insumos recebidos para industrialização.'),(484,6903,'Retorno de mercadoria recebida para industrialização e não aplicada no referido processo','Classificam-se neste código as remessas em devolução de insumos recebidos para industrialização e não aplicados no referido processo.'),(485,6904,'Remessa para venda fora do estabelecimento','Classificam-se neste código as remessas de mercadorias para venda fora do estabelecimento, inclusive por meio de veículos.'),(486,6905,'Remessa para depósito fechado ou armazém geral','Classificam-se neste código as remessas de mercadorias para depósito em depósito fechado ou armazém geral.'),(487,6906,'Retorno de mercadoria depositada em depósito fechado ou armazém geral','Classificam-se neste código os retornos de mercadorias depositadas em depósito fechado ou armazém geral ao estabelecimento depositante.'),(488,6907,'Retorno simbólico de mercadoria depositada em depósito fechado ou armazém geral','Classificam-se neste código os retornos simbólicos de mercadorias recebidas para depósito em depósito fechado ou armazém geral, quando as mercadorias depositadas tenham sido objeto de saída a qualquer título e que não devam retornar ao estabelecimento depositante.'),(489,6908,'Remessa de bem por conta de contrato de comodato','Classificam-se neste código as remessas de bens para o cumprimento de contrato de comodato.'),(490,6909,'Retorno de bem recebido por conta de contrato de comodato','Classificam-se neste código as remessas de bens em devolução após cumprido o contrato de comodato.'),(491,6910,'Remessa em bonificação, doação ou brinde','Classificam-se neste código as remessas de mercadorias a título de bonificação, doação ou brinde.'),(492,6911,'Remessa de amostra grátis','Classificam-se neste código as remessas de mercadorias a título de amostra grátis.'),(493,6912,'Remessa de mercadoria ou bem para demonstração','Classificam-se neste código as remessas de mercadorias ou bens para demonstração.'),(494,6913,'Retorno de mercadoria ou bem recebido para demonstração','Classificam-se neste código as remessas em devolução de mercadorias ou bens recebidos para demonstração.'),(495,6914,'Remessa de mercadoria ou bem para exposição ou feira','Classificam-se neste código as remessas de mercadorias ou bens para exposição ou feira.'),(496,6915,'Remessa de mercadoria ou bem para conserto ou reparo','Classificam-se neste código as remessas de mercadorias ou bens para conserto ou reparo.'),(497,6916,'Retorno de mercadoria ou bem recebido para conserto ou reparo','Classificam-se neste código as remessas em devolução de mercadorias ou bens recebidos para conserto ou reparo.'),(498,6917,'Remessa de mercadoria em consignação mercantil ou industrial','Classificam-se neste código as remessas de mercadorias a título de consignação mercantil ou industrial.'),(499,6918,'Devolução de mercadoria recebida em consignação mercantil ou industrial','Classificam-se neste código as devoluções de mercadorias recebidas anteriormente a título de consignação mercantil ou industrial.'),(500,6919,'Devolução simbólica de mercadoria vendida ou utilizada em processo industrial, recebida anteriormente em consignação mercantil ou industrial','Classificam-se neste código as devoluções simbólicas de mercadorias vendidas ou utilizadas em processo industrial, que tenham sido recebidas anteriormente a título de consignação mercantil ou industrial.'),(501,6920,'Remessa de vasilhame ou sacaria','Classificam-se neste código as remessas de vasilhame ou sacaria.'),(502,6921,'Devolução de vasilhame ou sacaria','Classificam-se neste código as saídas por devolução de vasilhame ou sacaria.'),(503,6922,'Lançamento efetuado a título de simples faturamento decorrente de venda para entrega futura','Classificam-se neste código os registros efetuados a título de simples faturamento decorrente de venda para entrega futura.'),(504,6923,'Remessa de mercadoria por conta e ordem de terceiros, em venda à ordem','Classificam-se neste código as saídas correspondentes à entrega de mercadorias por conta e ordem de terceiros, em vendas à ordem, cuja venda ao adquirente originário, foi classificada nos códigos 6.118 - Venda de produção do estabelecimento entregue ao destinatário por conta e ordem do adquirente originário, em venda à ordem ou 6.119 - Venda de mercadoria adquirida ou recebida de terceiros entregue ao destinatário por conta e ordem do adquirente originário, em venda à ordem.'),(505,6924,'Remessa para industrialização por conta e ordem do adquirente da mercadoria, quando esta não transitar pelo estabelecimento do adquirente','Classificam-se neste código as saídas de insumos com destino a estabelecimento industrializador, para serem industrializados por conta e ordem do adquirente, nas hipóteses em que os insumos não tenham transitado pelo estabelecimento do adquirente dos mesmos.'),(506,6925,'Retorno de mercadoria recebida para industrialização por conta e ordem do adquirente da mercadoria, quando aquela não transitar pelo estabelecimento do adquirente','Classificam-se neste código as remessas, pelo estabelecimento industrializador, dos insumos recebidos, por conta e ordem do adquirente, para industrialização e incorporados ao produto final, nas hipóteses em que os insumos não tenham transitado pelo estabelecimento do adquirente. O valor dos insumos nesta operação deverá ser igual ao valor dos insumos recebidos para industrialização.'),(507,6929,'Lançamento efetuado em decorrência de emissão de documento fiscal relativo a operação ou prestação também registrada em equipamento Emissor de Cupom Fiscal - ECF','Classificam-se neste código os registros relativos aos documentos fiscais emitidos em operações ou prestações que também tenham sido registradas em equipamento Emissor de Cupom Fiscal - ECF.'),(508,6931,'Lançamento efetuado em decorrência da responsabilidade de retenção do imposto por substituição tributária, atribuída ao remetente ou alienante da mercadoria, pelo serviço de transporte realizado por transportador autônomo ou por transportador não inscrito na unidade da Federação onde iniciado o serviço','Classificam-se neste código exclusivamente os lançamentos efetuados pelo remetente ou alienante da mercadoria quando lhe for atribuída a responsabilidade pelo recolhimento do imposto devido pelo serviço de transporte realizado por transportador autônomo ou por transportador não inscrito na unidade da Federação onde iniciado o serviço.'),(509,6932,'Prestação de serviço de transporte iniciada em unidade da Federação diversa daquela onde inscrito o prestador','Classificam-se neste código as prestações de serviço de transporte que tenham sido iniciadas em unidade da Federação diversa daquela onde o prestador está inscrito como contribuinte.'),(510,6933,'Prestação de serviço tributado pelo ISSQN (ajuste sinief 03/04)','Classificam-se neste código as prestações de serviços, de competência municipal, desde que informados em documentos autorizados pelo Estado'),(511,6949,'Outra saída de mercadoria ou prestação de serviço não especificado','Classificam-se neste código as outras saídas de mercadorias ou prestações de serviços que não tenham sido especificados nos códigos anteriores.'),(512,7000,'SAÍDAS OU PRESTAÇÕES DE SERVIÇOS PARA O EXTERIOR','Classificam-se, neste grupo, as operações ou prestações em que o destinatário esteja localizado em outro país'),(513,7100,'VENDAS DE PRODUÇÃO PRÓPRIA OU DE TERCEIROS',''),(514,7101,'Venda de produção do estabelecimento','Classificam-se neste código as vendas de produtos industrializados no estabelecimento. Também serão classificadas neste código as vendas de mercadorias por estabelecimento industrial de cooperativa.'),(515,7102,'Venda de mercadoria adquirida ou recebida de terceiros','Classificam-se neste código as vendas de mercadorias adquiridas ou recebidas de terceiros para industrialização ou comercialização, que não tenham sido objeto de qualquer processo industrial no estabelecimento. Também serão classificadas neste código as vendas de mercadorias por estabelecimento comercial de cooperativa.'),(516,7105,'Venda de produção do estabelecimento, que não deva por ele transitar','Classificam-se neste código as vendas de produtos industrializados no estabelecimento, armazenados em depósito fechado, armazém geral ou outro sem que haja retorno ao estabelecimento depositante.'),(517,7106,'Venda de mercadoria adquirida ou recebida de terceiros, que não deva por ele transitar','Classificam-se neste código as vendas de mercadorias adquiridas ou recebidas de terceiros para industrialização ou comercialização, armazenadas em depósito fechado, armazém geral ou outro, que não tenham sido objeto de qualquer processo industrial no estabelecimento sem que haja retorno ao estabelecimento depositante. Também serão classificadas neste código as vendas de mercadorias importadas, cuja saída ocorra do recinto alfandegado ou da repartição alfandegária onde se processou o desembaraço aduaneiro, com destino ao estabelecimento do comprador, sem transitar pelo estabelecimento do importador.'),(518,7127,'Venda de produção do estabelecimento sob o regime de drawback ','Classificam-se neste código as vendas de produtos industrializados no estabelecimento sob o regime de drawback , cujas compras foram classificadas no código 3.127 - Compra para industrialização sob o regime de drawback.'),(519,7200,'DEVOLUÇÕES DE COMPRAS PARA INDUSTRIALIZAÇÃO, COMERCIALIZAÇÃO OU ANULAÇÕES DE VALORES',''),(520,7201,'Devolução de compra para industrialização','Classificam-se neste código as devoluções de mercadorias adquiridas para serem utilizadas em processo de industrialização, cujas entradas tenham sido classificadas como Compra para industrialização.'),(521,7202,'Devolução de compra para comercialização','Classificam-se neste código as devoluções de mercadorias adquiridas para serem comercializadas, cujas entradas tenham sido classificadas como Compra para comercialização.'),(522,7205,'Anulação de valor relativo à aquisição de serviço de comunicação','Classificam-se neste código as anulações correspondentes a valores faturados indevidamente, decorrentes das aquisições de serviços de comunicação.'),(523,7206,'Anulação de valor relativo a aquisição de serviço de transporte','Classificam-se neste código as anulações correspondentes a valores faturados indevidamente, decorrentes das aquisições de serviços de transporte.'),(524,7207,'Anulação de valor relativo à compra de energia elétrica','Classificam-se neste código as anulações correspondentes a valores faturados indevidamente, decorrentes da compra de energia elétrica.'),(525,7210,'Devolução de compra para utilização na prestação de serviço','Classificam-se neste código as devoluções de mercadorias adquiridas para utilização na prestação de serviços, cujas entradas tenham sido classificadas no código 3.126 - Compra para utilização na prestação de serviço.'),(526,7211,'Devolução de compras para industrialização sob o regime de drawback ','Classificam-se neste código as devoluções de mercadorias adquiridas para serem utilizadas em processo de industrialização sob o regime de drawback e não utilizadas no referido processo, cujas entradas tenham sido classificadas no código 3.127 - Compra para industrialização sob o regime de drawback.'),(527,7250,'VENDAS DE ENERGIA ELÉTRICA',''),(528,7251,'Venda de energia elétrica para o exterior','Classificam-se neste código as vendas de energia elétrica para o exterior.'),(529,7300,'PRESTAÇÕES DE SERVIÇOS DE COMUNICAÇÃO',''),(530,7301,'Prestação de serviço de comunicação para execução de serviço da mesma natureza','Classificam-se neste código as prestações de serviços de comunicação destinados às prestações de serviços da mesma natureza.'),(531,7350,'PRESTAÇÕES DE SERVIÇO DE TRANSPORTE',''),(532,7358,'Prestação de serviço de transporte','Classificam-se neste código as prestações de serviços de transporte destinado a estabelecimento no exterior.'),(533,7500,'EXPORTAÇÃO DE MERCADORIAS RECEBIDAS COM FIM ESPECÍFICO DE EXPORTAÇÃO',''),(534,7501,'Exportação de mercadorias recebidas com fim específico de exportação','Classificam-se neste código as exportações das mercadorias recebidas anteriormente com finalidade específica de exportação, cujas entradas tenham sido classificadas nos códigos 1.501 - Entrada de mercadoria recebida com fim específico de exportação ou 2.501 - Entrada de mercadoria recebida com fim específico de exportação.'),(535,7550,'OPERAÇÕES COM BENS DE ATIVO IMOBILIZADO E MATERIAIS PARA USO OU CONSUMO',''),(536,7551,'Venda de bem do ativo imobilizado','Classificam-se neste código as vendas de bens integrantes do ativo imobilizado do estabelecimento.'),(537,7553,'Devolução de compra de bem para o ativo imobilizado','Classificam-se neste código as devoluções de bens adquiridos para integrar o ativo imobilizado do estabelecimento, cuja entrada foi classificada no código 3.551 - Compra de bem para o ativo imobilizado.'),(538,7556,'Devolução de compra de material de uso ou consumo','Classificam-se neste código as devoluções de mercadorias destinadas ao uso ou consumo do estabelecimento, cuja entrada tenha sido classificada no código 3.556 - Compra de material para uso ou consumo.'),(539,7900,'OUTRAS SAÍDAS DE MERCADORIAS OU PRESTAÇÕES DE SERVIÇOS',''),(540,7930,'Lançamento efetuado a título de devolução de bem cuja entrada tenha ocorrido sob amparo de regime especial aduaneiro de admissão temporária','Classificam-se neste código os lançamentos efetuados a título de saída em devolução de bens cuja entrada tenha ocorrido sob amparo de regime especial aduaneiro de admissão temporária.'),(541,7949,'Outra saída de mercadoria ou prestação de serviço não especificado','Classificam-se neste código as outras saídas de mercadorias ou prestações de serviços que não tenham sido especificados nos códigos anteriores.');

/*Table structure for table `cliente` */

DROP TABLE IF EXISTS `cliente`;

CREATE TABLE `cliente` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `ID_SITUACAO_CLIENTE` int(10) unsigned NOT NULL,
  `NOME` varchar(150) DEFAULT NULL,
  `FANTASIA` varchar(150) DEFAULT NULL,
  `EMAIL` varchar(250) DEFAULT NULL,
  `CPF_CNPJ` varchar(14) DEFAULT NULL,
  `RG` varchar(20) DEFAULT NULL,
  `ORGAO_RG` varchar(10) DEFAULT NULL,
  `INSCRICAO_ESTADUAL` varchar(30) DEFAULT NULL,
  `INSCRICAO_MUNICIPAL` varchar(30) DEFAULT NULL,
  `TIPO_PESSOA` char(1) DEFAULT NULL,
  `DATA_CADASTRO` date DEFAULT NULL,
  `DATA_EMISSAO_RG` date DEFAULT NULL,
  `SEXO` char(1) DEFAULT NULL,
  `LOGRADOURO` varchar(250) DEFAULT NULL,
  `NUMERO` varchar(6) DEFAULT NULL,
  `COMPLEMENTO` varchar(50) DEFAULT NULL,
  `CEP` varchar(8) DEFAULT NULL,
  `BAIRRO` varchar(100) DEFAULT NULL,
  `CIDADE` varchar(100) DEFAULT NULL,
  `UF` varchar(2) DEFAULT NULL,
  `FONE1` varchar(10) DEFAULT NULL,
  `FONE2` varchar(10) DEFAULT NULL,
  `CELULAR` varchar(10) DEFAULT NULL,
  `CONTATO` varchar(50) DEFAULT NULL,
  `CODIGO_IBGE_CIDADE` int(10) unsigned DEFAULT NULL,
  `CODIGO_IBGE_UF` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_SITUACAO_CLIENTE` (`ID_SITUACAO_CLIENTE`),
  CONSTRAINT `cliente_ibfk_1` FOREIGN KEY (`ID_SITUACAO_CLIENTE`) REFERENCES `situacao_cliente` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `cliente` */

insert  into `cliente`(`ID`,`ID_SITUACAO_CLIENTE`,`NOME`,`FANTASIA`,`EMAIL`,`CPF_CNPJ`,`RG`,`ORGAO_RG`,`INSCRICAO_ESTADUAL`,`INSCRICAO_MUNICIPAL`,`TIPO_PESSOA`,`DATA_CADASTRO`,`DATA_EMISSAO_RG`,`SEXO`,`LOGRADOURO`,`NUMERO`,`COMPLEMENTO`,`CEP`,`BAIRRO`,`CIDADE`,`UF`,`FONE1`,`FONE2`,`CELULAR`,`CONTATO`,`CODIGO_IBGE_CIDADE`,`CODIGO_IBGE_UF`) values (1,1,'João da Silva',NULL,'joao@t2ti.com','11111111111',NULL,NULL,NULL,NULL,'F',NULL,NULL,'M','QD 301 Lote 04 Sala','304',NULL,'71904540','Aguas Claras','Brasilia','DF','6130425277',NULL,NULL,NULL,NULL,NULL);

/*Table structure for table `dav_cabecalho` */

DROP TABLE IF EXISTS `dav_cabecalho`;

CREATE TABLE `dav_cabecalho` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `ID_PESSOA` int(10) unsigned DEFAULT NULL,
  `ID_EMPRESA` int(10) unsigned DEFAULT NULL,
  `NUMERO_DAV` varchar(10) DEFAULT NULL,
  `NUMERO_ECF` varchar(5) DEFAULT NULL,
  `CCF` int(10) unsigned DEFAULT NULL,
  `COO` int(10) unsigned DEFAULT NULL,
  `NOME_DESTINATARIO` varchar(100) DEFAULT NULL,
  `CPF_CNPJ_DESTINATARIO` varchar(14) DEFAULT NULL,
  `DATA_EMISSAO` date DEFAULT NULL,
  `HORA_EMISSAO` varchar(8) DEFAULT NULL,
  `SITUACAO` char(1) DEFAULT NULL,
  `TAXA_ACRESCIMO` decimal(20,6) DEFAULT NULL,
  `ACRESCIMO` decimal(20,6) DEFAULT NULL,
  `TAXA_DESCONTO` decimal(20,6) DEFAULT NULL,
  `DESCONTO` decimal(20,6) DEFAULT NULL,
  `SUBTOTAL` decimal(20,6) DEFAULT NULL,
  `VALOR` decimal(20,6) DEFAULT NULL,
  `IMPRESSO` char(1) DEFAULT NULL,
  `HASH_TRIPA` varchar(32) DEFAULT NULL,
  `HASH_INCREMENTO` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `dav_cabecalho` */

/*Table structure for table `dav_detalhe` */

DROP TABLE IF EXISTS `dav_detalhe`;

CREATE TABLE `dav_detalhe` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `ID_DAV_CABECALHO` int(10) unsigned NOT NULL,
  `ID_PRODUTO` int(10) unsigned NOT NULL,
  `NUMERO_DAV` varchar(10) DEFAULT NULL,
  `DATA_EMISSAO` date DEFAULT NULL,
  `ITEM` int(10) unsigned DEFAULT NULL,
  `QUANTIDADE` decimal(20,6) DEFAULT NULL,
  `VALOR_UNITARIO` decimal(20,6) DEFAULT NULL,
  `VALOR_TOTAL` decimal(20,6) DEFAULT NULL,
  `CANCELADO` char(1) DEFAULT NULL,
  `MESCLA_PRODUTO` char(1) DEFAULT NULL,
  `GTIN_PRODUTO` varchar(14) DEFAULT NULL,
  `NOME_PRODUTO` varchar(100) DEFAULT NULL,
  `UNIDADE_PRODUTO` varchar(10) DEFAULT NULL,
  `TOTALIZADOR_PARCIAL` varchar(10) DEFAULT NULL,
  `HASH_TRIPA` varchar(32) DEFAULT NULL,
  `HASH_INCREMENTO` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_DAV_CAB_DET` (`ID_DAV_CABECALHO`),
  KEY `FK_PRODUTO_DAV_DET` (`ID_PRODUTO`),
  CONSTRAINT `dav_detalhe_ibfk_1` FOREIGN KEY (`ID_DAV_CABECALHO`) REFERENCES `dav_cabecalho` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `dav_detalhe_ibfk_2` FOREIGN KEY (`ID_PRODUTO`) REFERENCES `produto` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `dav_detalhe` */

/*Table structure for table `ecf_caixa` */

DROP TABLE IF EXISTS `ecf_caixa`;

CREATE TABLE `ecf_caixa` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `NOME` varchar(30) DEFAULT NULL,
  `DATA_CADASTRO` date DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `ecf_caixa` */

insert  into `ecf_caixa`(`ID`,`NOME`,`DATA_CADASTRO`) values (1,'CAIXA 001','2010-08-15');

/*Table structure for table `ecf_cheque_cliente` */

DROP TABLE IF EXISTS `ecf_cheque_cliente`;

CREATE TABLE `ecf_cheque_cliente` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `ID_BANCO` int(10) unsigned NOT NULL,
  `ID_CLIENTE` int(10) unsigned NOT NULL,
  `NUMERO_CHEQUE` int(10) unsigned DEFAULT NULL,
  `DATA_CHEQUE` date DEFAULT NULL,
  `VALOR_CHEQUE` decimal(20,6) DEFAULT NULL,
  `OBSERVACOES` text,
  PRIMARY KEY (`ID`),
  KEY `FK_CLIENTE_CHEQUE` (`ID_CLIENTE`),
  KEY `FK_BANCO_CHEQUE` (`ID_BANCO`),
  CONSTRAINT `ecf_cheque_cliente_ibfk_1` FOREIGN KEY (`ID_CLIENTE`) REFERENCES `cliente` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `ecf_cheque_cliente_ibfk_2` FOREIGN KEY (`ID_BANCO`) REFERENCES `banco` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `ecf_cheque_cliente` */

/*Table structure for table `ecf_configuracao` */

DROP TABLE IF EXISTS `ecf_configuracao`;

CREATE TABLE `ecf_configuracao` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `ID_ECF_IMPRESSORA` int(10) unsigned NOT NULL,
  `ID_ECF_RESOLUCAO` int(10) unsigned NOT NULL,
  `ID_ECF_CAIXA` int(10) unsigned NOT NULL,
  `ID_ECF_EMPRESA` int(10) unsigned NOT NULL,
  `MENSAGEM_CUPOM` varchar(250) DEFAULT NULL,
  `PORTA_ECF` char(10) DEFAULT NULL,
  `PORTA_PINPAD` char(10) DEFAULT NULL,
  `PORTA_BALANCA` char(10) DEFAULT NULL,
  `IP_SERVIDOR` varchar(15) DEFAULT NULL,
  `IP_SITEF` varchar(15) DEFAULT NULL,
  `TIPO_TEF` char(2) DEFAULT NULL,
  `TITULO_TELA_CAIXA` varchar(100) DEFAULT NULL,
  `CAMINHO_IMAGENS_PRODUTOS` varchar(250) DEFAULT NULL,
  `CAMINHO_IMAGENS_MARKETING` varchar(250) DEFAULT NULL,
  `CAMINHO_IMAGENS_LAYOUT` varchar(250) DEFAULT NULL,
  `COR_JANELAS_INTERNAS` varchar(20) DEFAULT NULL,
  `MARKETING_ATIVO` char(1) DEFAULT NULL,
  `CFOP_ECF` int(10) unsigned DEFAULT NULL,
  `CFOP_NF2` int(10) unsigned DEFAULT NULL,
  `TIMEOUT_ECF` int(10) unsigned DEFAULT NULL,
  `INTERVALO_ECF` int(10) unsigned DEFAULT NULL,
  `DESCRICAO_SUPRIMENTO` varchar(20) DEFAULT NULL,
  `DESCRICAO_SANGRIA` varchar(20) DEFAULT NULL,
  `TEF_TIPO_GP` int(10) unsigned DEFAULT NULL,
  `TEF_TEMPO_ESPERA` int(10) unsigned DEFAULT NULL,
  `TEF_ESPERA_STS` int(10) unsigned DEFAULT NULL,
  `TEF_NUMERO_VIAS` int(10) unsigned DEFAULT NULL,
  `INDICE_GERENCIAL_DAV` int(10) unsigned DEFAULT NULL,
  `DECIMAIS_QUANTIDADE` int(10) unsigned DEFAULT NULL,
  `DECIMAIS_VALOR` int(10) unsigned DEFAULT NULL,
  `SINCRONIZADO` char(1) DEFAULT NULL,
  `GERENCIAL_MEIOS_PAGAMENTO` int(10) unsigned DEFAULT NULL,
  `GERENCIAL_IDENTIFICACAO_PAF` int(10) unsigned DEFAULT NULL,
  `GERENCIAL_PARAMETROS_CONFIGURACAO` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_EMPRESA_CONFIGURACAO` (`ID_ECF_EMPRESA`),
  KEY `FK_CAIXA_CONFIGURACAO` (`ID_ECF_CAIXA`),
  KEY `FK_RESOLUCAO_CONFIGURACAO` (`ID_ECF_RESOLUCAO`),
  KEY `FK_IMPRESSORA_CONFIGURACAO` (`ID_ECF_IMPRESSORA`),
  CONSTRAINT `ecf_configuracao_ibfk_1` FOREIGN KEY (`ID_ECF_EMPRESA`) REFERENCES `ecf_empresa` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `ecf_configuracao_ibfk_2` FOREIGN KEY (`ID_ECF_CAIXA`) REFERENCES `ecf_caixa` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `ecf_configuracao_ibfk_3` FOREIGN KEY (`ID_ECF_RESOLUCAO`) REFERENCES `ecf_resolucao` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `ecf_configuracao_ibfk_4` FOREIGN KEY (`ID_ECF_IMPRESSORA`) REFERENCES `ecf_impressora` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `ecf_configuracao` */

insert  into `ecf_configuracao`(`ID`,`ID_ECF_IMPRESSORA`,`ID_ECF_RESOLUCAO`,`ID_ECF_CAIXA`,`ID_ECF_EMPRESA`,`MENSAGEM_CUPOM`,`PORTA_ECF`,`PORTA_PINPAD`,`PORTA_BALANCA`,`IP_SERVIDOR`,`IP_SITEF`,`TIPO_TEF`,`TITULO_TELA_CAIXA`,`CAMINHO_IMAGENS_PRODUTOS`,`CAMINHO_IMAGENS_MARKETING`,`CAMINHO_IMAGENS_LAYOUT`,`COR_JANELAS_INTERNAS`,`MARKETING_ATIVO`,`CFOP_ECF`,`CFOP_NF2`,`TIMEOUT_ECF`,`INTERVALO_ECF`,`DESCRICAO_SUPRIMENTO`,`DESCRICAO_SANGRIA`,`TEF_TIPO_GP`,`TEF_TEMPO_ESPERA`,`TEF_ESPERA_STS`,`TEF_NUMERO_VIAS`,`INDICE_GERENCIAL_DAV`,`DECIMAIS_QUANTIDADE`,`DECIMAIS_VALOR`,`SINCRONIZADO`,`GERENCIAL_MEIOS_PAGAMENTO`,`GERENCIAL_IDENTIFICACAO_PAF`,`GERENCIAL_PARAMETROS_CONFIGURACAO`) values (1,1,1,1,1,'OBRIGADO. VOLTE SEMPRE.','COM1',NULL,NULL,NULL,NULL,'DI','T2Ti PDV - T2Ti Tecnologia da Informação LTDA. - (61) 3042.5277','/images/produtos/','/images/marketing/','/images/layout/','236,233,216','N',5102,5102,10,100,'SUPRIMENTO','SANGRIA',1,250,7,2,3,3,2,NULL,2,4,5);

/*Table structure for table `ecf_contador` */

DROP TABLE IF EXISTS `ecf_contador`;

CREATE TABLE `ecf_contador` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `ID_ECF_EMPRESA` int(10) unsigned NOT NULL,
  `CPF` varchar(11) DEFAULT NULL,
  `CNPJ` varchar(14) DEFAULT NULL,
  `NOME` varchar(100) DEFAULT NULL,
  `INSCRICAO_CRC` varchar(15) DEFAULT NULL,
  `FONE` varchar(15) DEFAULT NULL,
  `FAX` varchar(15) DEFAULT NULL,
  `LOGRADOURO` varchar(100) DEFAULT NULL,
  `NUMERO` int(10) unsigned DEFAULT NULL,
  `COMPLEMENTO` varchar(100) DEFAULT NULL,
  `BAIRRO` varchar(30) DEFAULT NULL,
  `CEP` varchar(8) DEFAULT NULL,
  `CODIGO_MUNICIPIO` int(10) unsigned DEFAULT NULL,
  `UF` char(2) DEFAULT NULL,
  `EMAIL` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_EMPRESA_CONTADOR` (`ID_ECF_EMPRESA`),
  CONSTRAINT `ecf_contador_ibfk_1` FOREIGN KEY (`ID_ECF_EMPRESA`) REFERENCES `ecf_empresa` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `ecf_contador` */

/*Table structure for table `ecf_documentos_emitidos` */

DROP TABLE IF EXISTS `ecf_documentos_emitidos`;

CREATE TABLE `ecf_documentos_emitidos` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `ID_ECF_MOVIMENTO` int(10) unsigned NOT NULL,
  `DATA_EMISSAO` date DEFAULT NULL,
  `HORA_EMISSAO` varchar(8) DEFAULT NULL,
  `TIPO` char(2) DEFAULT NULL,
  `COO` int(10) unsigned DEFAULT NULL,
  `SINCRONIZADO` char(1) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_MOVIMENTO_DOC_EMITIDOS` (`ID_ECF_MOVIMENTO`),
  CONSTRAINT `ecf_documentos_emitidos_ibfk_1` FOREIGN KEY (`ID_ECF_MOVIMENTO`) REFERENCES `ecf_movimento` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `ecf_documentos_emitidos` */

/*Table structure for table `ecf_empresa` */

DROP TABLE IF EXISTS `ecf_empresa`;

CREATE TABLE `ecf_empresa` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `ID_EMPRESA` int(10) unsigned NOT NULL,
  `RAZAO_SOCIAL` varchar(150) DEFAULT NULL,
  `NOME_FANTASIA` varchar(150) DEFAULT NULL,
  `CNPJ` varchar(14) DEFAULT NULL,
  `INSCRICAO_ESTADUAL` varchar(30) DEFAULT NULL,
  `INSCRICAO_MUNICIPAL` varchar(30) DEFAULT NULL,
  `MATRIZ_FILIAL` char(1) DEFAULT NULL,
  `DATA_CADASTRO` date DEFAULT NULL,
  `LOGRADOURO` varchar(100) DEFAULT NULL,
  `NUMERO` varchar(10) DEFAULT NULL,
  `COMPLEMENTO` varchar(100) DEFAULT NULL,
  `BAIRRO` varchar(50) DEFAULT NULL,
  `CIDADE` varchar(50) DEFAULT NULL,
  `CODIGO_IBGE_CIDADE` int(10) unsigned DEFAULT NULL,
  `CODIGO_IBGE_UF` int(10) unsigned DEFAULT NULL,
  `UF` char(2) DEFAULT NULL,
  `CEP` varchar(8) DEFAULT NULL,
  `FONE` varchar(10) DEFAULT NULL,
  `FAX` varchar(10) DEFAULT NULL,
  `CONTATO` varchar(30) DEFAULT NULL,
  `SUFRAMA` varchar(9) DEFAULT NULL,
  `EMAIL` varchar(250) DEFAULT NULL,
  `INSCRICAO_ESTADUAL_ST` varchar(30) DEFAULT NULL,
  `INSCRICAO_JUNTA_COMERCIAL` varchar(30) DEFAULT NULL,
  `DATA_INSC_JUNTA_COMERCIAL` date DEFAULT NULL,
  `DATA_INICIO_ATIVIDADES` date DEFAULT NULL,
  `IMAGEM_LOGOTIPO` text,
  `CRT` char(1) DEFAULT NULL,
  `TIPO_REGIME` char(1) DEFAULT NULL,
  `ALIQUOTA_PIS` decimal(20,6) DEFAULT NULL,
  `ALIQUOTA_COFINS` decimal(20,6) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_EMPRESA_FILIAL` (`ID_EMPRESA`),
  CONSTRAINT `ecf_empresa_ibfk_1` FOREIGN KEY (`ID_EMPRESA`) REFERENCES `ecf_empresa` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `ecf_empresa` */

insert  into `ecf_empresa`(`ID`,`ID_EMPRESA`,`RAZAO_SOCIAL`,`NOME_FANTASIA`,`CNPJ`,`INSCRICAO_ESTADUAL`,`INSCRICAO_MUNICIPAL`,`MATRIZ_FILIAL`,`DATA_CADASTRO`,`LOGRADOURO`,`NUMERO`,`COMPLEMENTO`,`BAIRRO`,`CIDADE`,`CODIGO_IBGE_CIDADE`,`CODIGO_IBGE_UF`,`UF`,`CEP`,`FONE`,`FAX`,`CONTATO`,`SUFRAMA`,`EMAIL`,`INSCRICAO_ESTADUAL_ST`,`INSCRICAO_JUNTA_COMERCIAL`,`DATA_INSC_JUNTA_COMERCIAL`,`DATA_INICIO_ATIVIDADES`,`IMAGEM_LOGOTIPO`,`CRT`,`TIPO_REGIME`,`ALIQUOTA_PIS`,`ALIQUOTA_COFINS`) values (1,1,'T2TI.COM TECNOLOGIA DA INFORMACAO LTDA','T2TI.COM','10793118000178','0751990400114','ISENTO',NULL,'2007-01-01','RUA DAS CARNAUBAS','4','PLAZZA','AGUAS CLARAS','BRASILIA',5300108,53,'DF','71904540','6130425277',NULL,'CLAUDIO',NULL,'t2ti.com@gmail.com','ISENTO',NULL,NULL,'2007-01-01',NULL,'3','1',NULL,NULL);

/*Table structure for table `ecf_estoque` */

DROP TABLE IF EXISTS `ecf_estoque`;

CREATE TABLE `ecf_estoque` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `ID_ECF_EMPRESA` int(10) unsigned NOT NULL,
  `ID_ECF_IMPRESSORA` int(10) unsigned NOT NULL,
  `NUMERO_SERIE_ECF` varchar(20) DEFAULT NULL,
  `DATA_ATUALIZACAO` date DEFAULT NULL,
  `HORA_ATUALIZACAO` varchar(8) DEFAULT NULL,
  `HASH_TRIPA` varchar(32) DEFAULT NULL,
  `HASH_INCREMENTO` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `ECF_ESTOQUE_FKIndex1` (`ID_ECF_IMPRESSORA`),
  KEY `ECF_ESTOQUE_FKIndex2` (`ID_ECF_EMPRESA`),
  CONSTRAINT `ecf_estoque_ibfk_1` FOREIGN KEY (`ID_ECF_IMPRESSORA`) REFERENCES `ecf_impressora` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `ecf_estoque_ibfk_2` FOREIGN KEY (`ID_ECF_EMPRESA`) REFERENCES `ecf_empresa` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `ecf_estoque` */

insert  into `ecf_estoque`(`ID`,`ID_ECF_EMPRESA`,`ID_ECF_IMPRESSORA`,`NUMERO_SERIE_ECF`,`DATA_ATUALIZACAO`,`HORA_ATUALIZACAO`,`HASH_TRIPA`,`HASH_INCREMENTO`) values (1,1,1,'DR0510BR000000228007','2012-02-15','09:28:31','a3fdda5f5b4bd0c96feb49125241abca',0);

/*Table structure for table `ecf_funcionario` */

DROP TABLE IF EXISTS `ecf_funcionario`;

CREATE TABLE `ecf_funcionario` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `NOME` varchar(100) DEFAULT NULL,
  `TELEFONE` varchar(10) DEFAULT NULL,
  `CELULAR` varchar(10) DEFAULT NULL,
  `EMAIL` varchar(250) DEFAULT NULL,
  `COMISSAO_VISTA` decimal(20,6) DEFAULT NULL,
  `COMISSAO_PRAZO` decimal(20,6) DEFAULT NULL,
  `NIVEL_AUTORIZACAO` char(1) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `ecf_funcionario` */

insert  into `ecf_funcionario`(`ID`,`NOME`,`TELEFONE`,`CELULAR`,`EMAIL`,`COMISSAO_VISTA`,`COMISSAO_PRAZO`,`NIVEL_AUTORIZACAO`) values (1,'MARIA',NULL,NULL,NULL,NULL,NULL,'O'),(2,'JOSE',NULL,NULL,NULL,NULL,NULL,'S'),(3,'ANTONIO',NULL,NULL,NULL,NULL,NULL,'G');

/*Table structure for table `ecf_impressora` */

DROP TABLE IF EXISTS `ecf_impressora`;

CREATE TABLE `ecf_impressora` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `NUMERO` int(10) unsigned DEFAULT NULL,
  `CODIGO` varchar(10) DEFAULT NULL,
  `SERIE` varchar(20) DEFAULT NULL,
  `IDENTIFICACAO` varchar(250) DEFAULT NULL,
  `MC` char(2) DEFAULT NULL,
  `MD` char(2) DEFAULT NULL,
  `VR` char(2) DEFAULT NULL,
  `TIPO` varchar(7) DEFAULT NULL,
  `MARCA` varchar(30) DEFAULT NULL,
  `MODELO` varchar(30) DEFAULT NULL,
  `MODELO_ACBR` varchar(30) DEFAULT NULL,
  `MODELO_DOCUMENTO_FISCAL` char(2) DEFAULT NULL,
  `VERSAO` varchar(30) DEFAULT NULL,
  `LE` char(1) DEFAULT NULL,
  `LEF` char(1) DEFAULT NULL,
  `MFD` char(1) DEFAULT NULL,
  `LACRE_NA_MFD` char(1) DEFAULT NULL,
  `DOCTO` varchar(60) DEFAULT NULL,
  `DATA_INSTALACAO_SB` date DEFAULT NULL,
  `HORA_INSTALACAO_SB` varchar(8) DEFAULT NULL,
  `NUMERO_ECF` varchar(5) DEFAULT NULL,
  `MF_ADICIONAL` char(1) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `ecf_impressora` */

insert  into `ecf_impressora`(`ID`,`NUMERO`,`CODIGO`,`SERIE`,`IDENTIFICACAO`,`MC`,`MD`,`VR`,`TIPO`,`MARCA`,`MODELO`,`MODELO_ACBR`,`MODELO_DOCUMENTO_FISCAL`,`VERSAO`,`LE`,`LEF`,`MFD`,`LACRE_NA_MFD`,`DOCTO`,`DATA_INSTALACAO_SB`,`HORA_INSTALACAO_SB`,`NUMERO_ECF`,`MF_ADICIONAL`) values (1,1,'081201','DR0510BR000000228007','08|12|01|IF |   DARUMA      |   FS-700H          |   01.01.00    |1|1|SIM|SIM','08','12','01','IF','DARUMA','FS-700H','4','2D','01.01.00','1','1','S','S','TDF 025/08 PT-41','2011-01-04','09:30:29','001',NULL);

/*Table structure for table `ecf_movimento` */

DROP TABLE IF EXISTS `ecf_movimento`;

CREATE TABLE `ecf_movimento` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `ID_ECF_EMPRESA` int(10) unsigned NOT NULL,
  `ID_ECF_TURNO` int(10) unsigned NOT NULL,
  `ID_ECF_IMPRESSORA` int(10) unsigned NOT NULL,
  `ID_ECF_OPERADOR` int(10) unsigned NOT NULL,
  `ID_ECF_CAIXA` int(10) unsigned NOT NULL,
  `ID_GERENTE_SUPERVISOR` int(10) unsigned NOT NULL,
  `DATA_ABERTURA` date DEFAULT NULL,
  `HORA_ABERTURA` varchar(8) DEFAULT NULL,
  `DATA_FECHAMENTO` date DEFAULT NULL,
  `HORA_FECHAMENTO` varchar(8) DEFAULT NULL,
  `TOTAL_SUPRIMENTO` decimal(20,6) DEFAULT NULL,
  `TOTAL_SANGRIA` decimal(20,6) DEFAULT NULL,
  `TOTAL_NAO_FISCAL` decimal(20,6) DEFAULT NULL,
  `TOTAL_VENDA` decimal(20,6) DEFAULT NULL,
  `TOTAL_DESCONTO` decimal(20,6) DEFAULT NULL,
  `TOTAL_ACRESCIMO` decimal(20,6) DEFAULT NULL,
  `TOTAL_FINAL` decimal(20,6) DEFAULT NULL,
  `TOTAL_RECEBIDO` decimal(20,6) DEFAULT NULL,
  `TOTAL_TROCO` decimal(20,6) DEFAULT NULL,
  `TOTAL_CANCELADO` decimal(20,6) DEFAULT NULL,
  `STATUS_MOVIMENTO` char(1) NOT NULL,
  `SINCRONIZADO` char(1) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_CAIXA_MOVIMENTO` (`ID_ECF_CAIXA`),
  KEY `FK_OPERADOR_MOVIMENTO` (`ID_ECF_OPERADOR`),
  KEY `FK_TURNO_MOVIMENTO` (`ID_ECF_TURNO`),
  KEY `FK_IMPRESSORA_MOVIMENTO` (`ID_ECF_IMPRESSORA`),
  KEY `ECF_MOVIMENTO_FKIndex5` (`ID_ECF_EMPRESA`),
  CONSTRAINT `ecf_movimento_ibfk_1` FOREIGN KEY (`ID_ECF_CAIXA`) REFERENCES `ecf_caixa` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `ecf_movimento_ibfk_2` FOREIGN KEY (`ID_ECF_OPERADOR`) REFERENCES `ecf_operador` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `ecf_movimento_ibfk_3` FOREIGN KEY (`ID_ECF_TURNO`) REFERENCES `ecf_turno` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `ecf_movimento_ibfk_4` FOREIGN KEY (`ID_ECF_IMPRESSORA`) REFERENCES `ecf_impressora` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `ecf_movimento_ibfk_5` FOREIGN KEY (`ID_ECF_EMPRESA`) REFERENCES `ecf_empresa` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `ecf_movimento` */

insert  into `ecf_movimento`(`ID`,`ID_ECF_EMPRESA`,`ID_ECF_TURNO`,`ID_ECF_IMPRESSORA`,`ID_ECF_OPERADOR`,`ID_ECF_CAIXA`,`ID_GERENTE_SUPERVISOR`,`DATA_ABERTURA`,`HORA_ABERTURA`,`DATA_FECHAMENTO`,`HORA_FECHAMENTO`,`TOTAL_SUPRIMENTO`,`TOTAL_SANGRIA`,`TOTAL_NAO_FISCAL`,`TOTAL_VENDA`,`TOTAL_DESCONTO`,`TOTAL_ACRESCIMO`,`TOTAL_FINAL`,`TOTAL_RECEBIDO`,`TOTAL_TROCO`,`TOTAL_CANCELADO`,`STATUS_MOVIMENTO`,`SINCRONIZADO`) values (1,1,1,1,1,1,2,'2012-02-15','9:27:0',NULL,NULL,'0.000000',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'A','N');

/*Table structure for table `ecf_operador` */

DROP TABLE IF EXISTS `ecf_operador`;

CREATE TABLE `ecf_operador` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `ID_ECF_FUNCIONARIO` int(10) unsigned NOT NULL,
  `LOGIN` varchar(20) DEFAULT NULL,
  `SENHA` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_FUNCIONARIO_OPERADOR` (`ID_ECF_FUNCIONARIO`),
  CONSTRAINT `ecf_operador_ibfk_1` FOREIGN KEY (`ID_ECF_FUNCIONARIO`) REFERENCES `ecf_funcionario` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `ecf_operador` */

insert  into `ecf_operador`(`ID`,`ID_ECF_FUNCIONARIO`,`LOGIN`,`SENHA`) values (1,1,'MARIA','123'),(2,2,'JOSE','123'),(3,3,'ANTONIO','123');

/*Table structure for table `ecf_posicao_componentes` */

DROP TABLE IF EXISTS `ecf_posicao_componentes`;

CREATE TABLE `ecf_posicao_componentes` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `ID_ECF_RESOLUCAO` int(10) unsigned NOT NULL,
  `NOME` varchar(100) DEFAULT NULL,
  `ALTURA` int(10) unsigned DEFAULT NULL,
  `LARGURA` int(10) unsigned DEFAULT NULL,
  `TOPO` int(10) unsigned DEFAULT NULL,
  `ESQUERDA` int(10) unsigned DEFAULT NULL,
  `TAMANHO_FONTE` int(10) unsigned DEFAULT '0',
  `TEXTO` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_RESOLUCAO_POSICAO_COMPONENTES` (`ID_ECF_RESOLUCAO`),
  CONSTRAINT `ecf_posicao_componentes_ibfk_1` FOREIGN KEY (`ID_ECF_RESOLUCAO`) REFERENCES `ecf_resolucao` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=114 DEFAULT CHARSET=latin1;

/*Data for the table `ecf_posicao_componentes` */

insert  into `ecf_posicao_componentes`(`ID`,`ID_ECF_RESOLUCAO`,`NOME`,`ALTURA`,`LARGURA`,`TOPO`,`ESQUERDA`,`TAMANHO_FONTE`,`TEXTO`) values (1,1,'panelBobina',360,405,240,40,14,''),(2,1,'editCodigo',28,209,263,486,18,''),(3,1,'editQuantidade',28,209,362,486,18,''),(4,1,'editSubTotal',28,261,562,725,18,''),(5,1,'editTotalItem',28,209,562,486,18,''),(6,1,'editUnitario',28,209,463,486,18,''),(7,1,'imageProduto',250,250,249,731,0,''),(8,1,'labelDescricaoProduto',80,945,111,39,36,''),(9,1,'labelMensagens',53,497,646,487,18,''),(10,1,'labelTotalGeral',45,402,650,40,27,''),(11,1,'panelBotoes',56,950,705,38,0,''),(12,1,'panelF1',25,158,2,3,0,''),(13,1,'panelF2',25,158,2,160,0,''),(14,1,'panelF3',25,158,2,317,0,''),(15,1,'panelF4',25,158,2,474,0,''),(16,1,'panelF5',25,158,2,631,0,''),(17,1,'panelF6',25,158,2,789,0,''),(18,1,'panelF7',25,158,28,3,0,''),(19,1,'panelF8',25,158,28,160,0,''),(20,1,'panelF9',25,158,28,317,0,''),(21,1,'panelF10',25,158,28,474,0,''),(22,1,'panelF11',25,158,28,631,0,''),(23,1,'panelF12',25,158,28,789,0,''),(24,1,'imageF1',21,21,2,2,0,''),(25,1,'panelMenuFiscal',200,213,82,10,0,''),(26,1,'panelMenuOperacoes',200,213,82,10,0,''),(27,1,'panelMenuPrincipal',200,213,82,10,0,''),(28,1,'panelSubMenu',212,467,280,10,0,''),(29,1,'labelTitulo',20,710,10,300,14,''),(30,2,'panelBobina',284,320,185,32,8,''),(31,2,'editCodigo',24,162,205,381,13,''),(32,2,'editQuantidade',24,162,282,381,13,''),(33,2,'editSubTotal',24,203,438,567,13,''),(34,2,'editTotalItem',24,162,438,381,13,''),(35,2,'editUnitario',24,162,359,381,13,''),(36,2,'imageProduto',190,190,197,574,0,''),(37,2,'labelDescricaoProduto',66,736,86,32,28,''),(38,2,'labelMensagens',41,390,504,380,13,''),(39,2,'labelTotalGeral',37,317,507,31,18,''),(40,2,'panelBotoes',46,746,549,27,0,''),(41,2,'panelF1',23,123,0,3,0,''),(42,2,'panelF2',23,123,0,126,0,''),(43,2,'panelF3',23,123,0,249,0,''),(44,2,'panelF4',23,123,0,372,0,''),(45,2,'panelF5',23,123,0,495,0,''),(46,2,'panelF6',23,123,0,619,0,''),(47,2,'panelF7',23,123,23,3,0,''),(48,2,'panelF8',23,123,23,126,0,''),(49,2,'panelF9',23,123,23,249,0,''),(50,2,'panelF10',23,123,23,372,0,''),(51,2,'panelF11',23,123,23,495,0,''),(52,2,'panelF12',23,123,23,619,0,''),(53,2,'imageF1',21,21,1,2,0,''),(54,2,'panelMenuFiscal',200,213,82,10,0,''),(55,2,'panelMenuOperacoes',200,213,82,10,0,''),(56,2,'panelMenuPrincipal',200,213,82,10,0,''),(57,2,'panelSubMenu',212,467,280,10,0,''),(58,2,'labelTitulo',20,600,7,192,14,''),(59,2,'imageF2',21,21,1,2,0,''),(60,2,'imageF3',21,21,1,2,0,''),(61,2,'imageF4',21,21,1,2,0,''),(62,2,'imageF5',21,21,1,2,0,''),(63,2,'imageF6',21,21,1,2,0,''),(64,2,'imageF7',21,21,1,2,0,''),(65,2,'imageF8',21,21,1,2,0,''),(66,2,'imageF9',21,21,1,2,0,''),(67,2,'imageF10',21,21,1,2,0,''),(68,2,'imageF11',21,21,1,2,0,''),(69,2,'imageF12',21,21,1,2,0,''),(70,1,'imageF2',21,21,2,2,0,''),(71,1,'imageF3',21,21,2,2,0,''),(72,1,'imageF4',21,21,2,2,0,''),(73,1,'imageF5',21,21,2,2,0,''),(74,1,'imageF6',21,21,2,2,0,''),(75,1,'imageF7',21,21,2,2,0,''),(76,1,'imageF8',21,21,2,2,0,''),(77,1,'imageF9',21,21,2,2,0,''),(78,1,'imageF10',21,21,2,2,0,''),(79,1,'imageF11',21,21,2,2,0,''),(80,1,'imageF12',21,21,2,2,0,''),(81,1,'panelPrincipal',768,1024,0,0,0,''),(82,2,'panelPrincipal',600,800,0,0,0,''),(83,1,'labelF1',13,158,5,30,11,'F1 - Identifica Cliente'),(84,1,'labelF2',13,158,5,30,11,'F2 - Menu Principal'),(85,1,'labelF3',13,158,5,30,11,'F3 - Menu Operações'),(86,1,'labelF4',13,158,5,30,11,'F4 - Menu Fiscal'),(87,1,'labelF5',13,158,5,30,11,'F5 - Dados NF'),(88,1,'labelF6',13,158,5,30,11,'F6 - Pesquisa Produto'),(89,1,'labelF7',13,158,5,30,11,'F7 - Encerra Venda'),(90,1,'labelF8',13,158,5,30,11,'F8 - Cancela Item'),(91,1,'labelF9',13,158,5,30,11,'F9 - Cancela Cupom'),(92,1,'labelF10',13,158,5,30,11,'F10 - Concede Desconto'),(93,1,'labelF11',13,158,5,30,11,'F11 - Identifica Vendedor'),(94,1,'labelF12',13,158,5,30,11,'F12 - Sai do Caixa'),(95,2,'labelF1',13,123,5,30,11,'F1-Cliente'),(96,2,'labelF2',13,123,5,30,11,'F2-Menu Principal'),(97,2,'labelF3',13,123,5,30,11,'F3-Operações'),(98,2,'labelF4',13,123,5,30,11,'F4-Menu Fiscal'),(99,2,'labelF5',13,123,5,30,11,'F5-Calculadora'),(100,2,'labelF6',13,123,5,30,11,'F6-Pesquisa'),(101,2,'labelF7',13,123,5,30,11,'F7-Encerra Venda'),(102,2,'labelF8',13,123,5,30,11,'F8-Cancela Item'),(103,2,'labelF9',13,123,5,30,11,'F9-Cancela Cupom'),(104,2,'labelF10',13,123,5,30,11,'F10-Desconto'),(105,2,'labelF11',13,123,5,30,11,'F11-Vendedor'),(106,2,'labelF12',13,123,5,30,11,'F12-Sai do Caixa'),(108,1,'Bobina',360,405,0,0,14,''),(109,2,'Bobina',284,320,0,0,10,''),(110,1,'labelOperador',14,230,60,754,0,''),(111,1,'labelCaixa',14,230,80,754,0,''),(112,2,'labelOperador',14,230,40,500,0,''),(113,2,'labelCaixa',14,230,60,500,0,'');

/*Table structure for table `ecf_pre_venda_cabecalho` */

DROP TABLE IF EXISTS `ecf_pre_venda_cabecalho`;

CREATE TABLE `ecf_pre_venda_cabecalho` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `DATA_PV` date DEFAULT NULL,
  `HORA_PV` varchar(8) DEFAULT NULL,
  `SITUACAO` char(1) DEFAULT NULL,
  `CCF` int(10) unsigned DEFAULT NULL,
  `VALOR` decimal(20,6) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `ecf_pre_venda_cabecalho` */

/*Table structure for table `ecf_pre_venda_detalhe` */

DROP TABLE IF EXISTS `ecf_pre_venda_detalhe`;

CREATE TABLE `ecf_pre_venda_detalhe` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `ID_PRODUTO` int(10) unsigned NOT NULL,
  `ID_ECF_PRE_VENDA_CABECALHO` int(10) unsigned NOT NULL,
  `QUANTIDADE` decimal(20,6) DEFAULT NULL,
  `VALOR_UNITARIO` decimal(20,6) DEFAULT NULL,
  `VALOR_TOTAL` decimal(20,6) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_PV_CAB_DET` (`ID_ECF_PRE_VENDA_CABECALHO`),
  KEY `FK_PRODUTO_PV_DET` (`ID_PRODUTO`),
  CONSTRAINT `ecf_pre_venda_detalhe_ibfk_1` FOREIGN KEY (`ID_ECF_PRE_VENDA_CABECALHO`) REFERENCES `ecf_pre_venda_cabecalho` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `ecf_pre_venda_detalhe_ibfk_2` FOREIGN KEY (`ID_PRODUTO`) REFERENCES `produto` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `ecf_pre_venda_detalhe` */

/*Table structure for table `ecf_recebimento_nao_fiscal` */

DROP TABLE IF EXISTS `ecf_recebimento_nao_fiscal`;

CREATE TABLE `ecf_recebimento_nao_fiscal` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `ID_ECF_MOVIMENTO` int(10) unsigned NOT NULL,
  `DATA_RECBTO` date DEFAULT NULL,
  `DESCRICAO` varchar(50) DEFAULT NULL,
  `VALOR` decimal(20,6) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_MOVIMENTO_RECBTO_NAO_FISCAL` (`ID_ECF_MOVIMENTO`),
  CONSTRAINT `ecf_recebimento_nao_fiscal_ibfk_1` FOREIGN KEY (`ID_ECF_MOVIMENTO`) REFERENCES `ecf_movimento` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `ecf_recebimento_nao_fiscal` */

/*Table structure for table `ecf_resolucao` */

DROP TABLE IF EXISTS `ecf_resolucao`;

CREATE TABLE `ecf_resolucao` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `RESOLUCAO_TELA` varchar(20) DEFAULT NULL,
  `LARGURA` int(10) unsigned DEFAULT NULL,
  `ALTURA` int(10) unsigned DEFAULT NULL,
  `IMAGEM_TELA` varchar(50) DEFAULT NULL,
  `IMAGEM_MENU` varchar(50) DEFAULT NULL,
  `IMAGEM_SUBMENU` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `ecf_resolucao` */

insert  into `ecf_resolucao`(`ID`,`RESOLUCAO_TELA`,`LARGURA`,`ALTURA`,`IMAGEM_TELA`,`IMAGEM_MENU`,`IMAGEM_SUBMENU`) values (1,'1024X768',1024,768,'Tela1024x768.jpg',NULL,NULL),(2,'800X600',800,600,'Tela800x600.jpg',NULL,NULL);

/*Table structure for table `ecf_sangria` */

DROP TABLE IF EXISTS `ecf_sangria`;

CREATE TABLE `ecf_sangria` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `ID_ECF_MOVIMENTO` int(10) unsigned NOT NULL,
  `DATA_SANGRIA` date DEFAULT NULL,
  `VALOR` decimal(20,6) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_MOVIMENTO_SANGRIA` (`ID_ECF_MOVIMENTO`),
  CONSTRAINT `ecf_sangria_ibfk_1` FOREIGN KEY (`ID_ECF_MOVIMENTO`) REFERENCES `ecf_movimento` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `ecf_sangria` */

/*Table structure for table `ecf_suprimento` */

DROP TABLE IF EXISTS `ecf_suprimento`;

CREATE TABLE `ecf_suprimento` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `ID_ECF_MOVIMENTO` int(10) unsigned NOT NULL,
  `DATA_SUPRIMENTO` date DEFAULT NULL,
  `VALOR` decimal(20,6) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_MOVIMENTO_SUPRIMENTO` (`ID_ECF_MOVIMENTO`),
  CONSTRAINT `ecf_suprimento_ibfk_1` FOREIGN KEY (`ID_ECF_MOVIMENTO`) REFERENCES `ecf_movimento` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `ecf_suprimento` */

/*Table structure for table `ecf_tipo_pagamento` */

DROP TABLE IF EXISTS `ecf_tipo_pagamento`;

CREATE TABLE `ecf_tipo_pagamento` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `CODIGO` char(3) DEFAULT NULL,
  `DESCRICAO` varchar(20) DEFAULT NULL,
  `TEF` char(1) DEFAULT NULL,
  `IMPRIME_VINCULADO` char(1) DEFAULT NULL,
  `PERMITE_TROCO` char(1) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `ecf_tipo_pagamento` */

insert  into `ecf_tipo_pagamento`(`ID`,`CODIGO`,`DESCRICAO`,`TEF`,`IMPRIME_VINCULADO`,`PERMITE_TROCO`) values (1,'01','DINHEIRO','N','N',NULL),(2,'02','CHEQUE','N','S',NULL),(3,'03','TEF','S','S',NULL);

/*Table structure for table `ecf_total_tipo_pgto` */

DROP TABLE IF EXISTS `ecf_total_tipo_pgto`;

CREATE TABLE `ecf_total_tipo_pgto` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `ID_ECF_VENDA_CABECALHO` int(10) unsigned NOT NULL,
  `ID_ECF_TIPO_PAGAMENTO` int(10) unsigned NOT NULL,
  `VALOR` decimal(20,6) DEFAULT NULL,
  `NSU` varchar(30) DEFAULT NULL,
  `ESTORNO` char(1) DEFAULT NULL,
  `REDE` varchar(10) DEFAULT NULL,
  `CARTAO_DC` char(1) DEFAULT NULL,
  `SERIE_ECF` varchar(20) DEFAULT NULL,
  `COO` int(10) unsigned DEFAULT NULL,
  `CCF` int(10) unsigned DEFAULT NULL,
  `GNF` int(10) unsigned DEFAULT NULL,
  `SINCRONIZADO` char(1) DEFAULT NULL,
  `HASH_TRIPA` varchar(32) DEFAULT NULL,
  `HASH_INCREMENTO` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_TIPO_PGTO_TOTAL` (`ID_ECF_TIPO_PAGAMENTO`),
  KEY `FK_VENDA_CAB_TOTAL_TIPO_PGTO` (`ID_ECF_VENDA_CABECALHO`),
  CONSTRAINT `ecf_total_tipo_pgto_ibfk_1` FOREIGN KEY (`ID_ECF_TIPO_PAGAMENTO`) REFERENCES `ecf_tipo_pagamento` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `ecf_total_tipo_pgto_ibfk_2` FOREIGN KEY (`ID_ECF_VENDA_CABECALHO`) REFERENCES `ecf_venda_cabecalho` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `ecf_total_tipo_pgto` */

insert  into `ecf_total_tipo_pgto`(`ID`,`ID_ECF_VENDA_CABECALHO`,`ID_ECF_TIPO_PAGAMENTO`,`VALOR`,`NSU`,`ESTORNO`,`REDE`,`CARTAO_DC`,`SERIE_ECF`,`COO`,`CCF`,`GNF`,`SINCRONIZADO`,`HASH_TRIPA`,`HASH_INCREMENTO`) values (1,1,1,'120.000000','','N','',NULL,'DR0510BR000000228007',2095,926,594,NULL,'75965bc9aba855e15b0b976f9012f6db',0),(2,2,1,'10.000000','','N','',NULL,'DR0510BR000000228007',2096,927,594,NULL,'32a1e7facc5348cf08c04a38d6f9c154',0);

/*Table structure for table `ecf_turno` */

DROP TABLE IF EXISTS `ecf_turno`;

CREATE TABLE `ecf_turno` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `DESCRICAO` varchar(10) DEFAULT NULL,
  `HORA_INICIO` varchar(8) DEFAULT NULL,
  `HORA_FIM` varchar(8) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

/*Data for the table `ecf_turno` */

insert  into `ecf_turno`(`ID`,`DESCRICAO`,`HORA_INICIO`,`HORA_FIM`) values (1,'TURNO 01','06:00:00','12:00:00'),(2,'TURNO 02','12:00:00','18:00:00'),(3,'TURNO 03','18:00:00','24:00:00'),(4,'TURNO 04','24:00:00','06:00:00'),(5,'ALMOCO','12:00:00','14:00:00');

/*Table structure for table `ecf_venda_cabecalho` */

DROP TABLE IF EXISTS `ecf_venda_cabecalho`;

CREATE TABLE `ecf_venda_cabecalho` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `ID_ECF_DAV` int(10) unsigned DEFAULT NULL,
  `ID_ECF_PRE_VENDA_CABECALHO` int(10) unsigned DEFAULT NULL,
  `ID_CLIENTE` int(10) unsigned DEFAULT NULL,
  `ID_ECF_FUNCIONARIO` int(10) unsigned DEFAULT NULL,
  `ID_ECF_MOVIMENTO` int(10) unsigned NOT NULL,
  `SERIE_ECF` varchar(20) DEFAULT NULL,
  `CFOP` int(10) unsigned DEFAULT NULL,
  `COO` int(10) unsigned DEFAULT NULL,
  `CCF` int(10) unsigned DEFAULT NULL,
  `DATA_VENDA` date DEFAULT NULL,
  `HORA_VENDA` varchar(8) DEFAULT NULL,
  `VALOR_VENDA` decimal(20,6) DEFAULT NULL,
  `TAXA_DESCONTO` decimal(20,6) DEFAULT NULL,
  `DESCONTO` decimal(20,6) DEFAULT NULL,
  `TAXA_ACRESCIMO` decimal(20,6) DEFAULT NULL,
  `ACRESCIMO` decimal(20,6) DEFAULT NULL,
  `VALOR_FINAL` decimal(20,6) DEFAULT NULL,
  `VALOR_RECEBIDO` decimal(20,6) DEFAULT NULL,
  `TROCO` decimal(20,6) DEFAULT NULL,
  `VALOR_CANCELADO` decimal(20,6) DEFAULT NULL,
  `SINCRONIZADO` char(1) DEFAULT NULL,
  `TOTAL_PRODUTOS` decimal(20,6) DEFAULT NULL,
  `TOTAL_DOCUMENTO` decimal(20,6) DEFAULT NULL,
  `BASE_ICMS` decimal(20,6) DEFAULT NULL,
  `ICMS` decimal(20,6) DEFAULT NULL,
  `ICMS_OUTRAS` decimal(20,6) DEFAULT NULL,
  `ISSQN` decimal(20,6) DEFAULT NULL,
  `PIS` decimal(20,6) DEFAULT NULL,
  `COFINS` decimal(20,6) DEFAULT NULL,
  `ACRESCIMO_ITENS` decimal(20,6) DEFAULT NULL,
  `DESCONTO_ITENS` decimal(20,6) DEFAULT NULL,
  `STATUS_VENDA` char(1) DEFAULT NULL,
  `NOME_CLIENTE` varchar(100) DEFAULT NULL,
  `CPF_CNPJ_CLIENTE` varchar(14) DEFAULT NULL,
  `CUPOM_CANCELADO` char(1) DEFAULT NULL,
  `HASH_TRIPA` varchar(32) DEFAULT NULL,
  `HASH_INCREMENTO` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_MOVIMENTO_VENDA_CAB` (`ID_ECF_MOVIMENTO`),
  KEY `FK_VENDEDOR_VENDA` (`ID_ECF_FUNCIONARIO`),
  KEY `FK_CLIENTE_VENDA` (`ID_CLIENTE`),
  KEY `FK_PV_VENDA` (`ID_ECF_PRE_VENDA_CABECALHO`),
  KEY `FK_DAV_VENDA` (`ID_ECF_DAV`),
  CONSTRAINT `ecf_venda_cabecalho_ibfk_1` FOREIGN KEY (`ID_ECF_MOVIMENTO`) REFERENCES `ecf_movimento` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `ecf_venda_cabecalho_ibfk_2` FOREIGN KEY (`ID_ECF_FUNCIONARIO`) REFERENCES `ecf_funcionario` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `ecf_venda_cabecalho_ibfk_3` FOREIGN KEY (`ID_CLIENTE`) REFERENCES `cliente` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `ecf_venda_cabecalho_ibfk_4` FOREIGN KEY (`ID_ECF_PRE_VENDA_CABECALHO`) REFERENCES `ecf_pre_venda_cabecalho` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `ecf_venda_cabecalho_ibfk_5` FOREIGN KEY (`ID_ECF_DAV`) REFERENCES `dav_cabecalho` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `ecf_venda_cabecalho` */

insert  into `ecf_venda_cabecalho`(`ID`,`ID_ECF_DAV`,`ID_ECF_PRE_VENDA_CABECALHO`,`ID_CLIENTE`,`ID_ECF_FUNCIONARIO`,`ID_ECF_MOVIMENTO`,`SERIE_ECF`,`CFOP`,`COO`,`CCF`,`DATA_VENDA`,`HORA_VENDA`,`VALOR_VENDA`,`TAXA_DESCONTO`,`DESCONTO`,`TAXA_ACRESCIMO`,`ACRESCIMO`,`VALOR_FINAL`,`VALOR_RECEBIDO`,`TROCO`,`VALOR_CANCELADO`,`SINCRONIZADO`,`TOTAL_PRODUTOS`,`TOTAL_DOCUMENTO`,`BASE_ICMS`,`ICMS`,`ICMS_OUTRAS`,`ISSQN`,`PIS`,`COFINS`,`ACRESCIMO_ITENS`,`DESCONTO_ITENS`,`STATUS_VENDA`,`NOME_CLIENTE`,`CPF_CNPJ_CLIENTE`,`CUPOM_CANCELADO`,`HASH_TRIPA`,`HASH_INCREMENTO`) values (1,NULL,NULL,NULL,NULL,1,'DR0510BR000000228007',5102,2095,926,'2012-02-15','09:28:17','120.000000','0.000000','0.000000','0.000000','0.000000','120.000000','120.000000','0.000000',NULL,NULL,'120.000000','120.000000','120.000000','14.400000','0.000000',NULL,NULL,NULL,NULL,NULL,'F',NULL,NULL,'N','50e8f7b34df6a5ae398c5b9b102b9f18',0),(2,NULL,NULL,NULL,NULL,1,'DR0510BR000000228007',5102,2096,927,'2012-02-15','09:28:36','10.000000','0.000000','0.000000','0.000000','0.000000','10.000000','10.000000','0.000000','10.000000',NULL,'10.000000','10.000000','10.000000','0.700000','0.000000',NULL,NULL,NULL,NULL,NULL,'C',NULL,NULL,'S','224457dadf829548e3dad76d7acb0548',0),(3,NULL,NULL,NULL,NULL,1,'DR0510BR000000228007',5102,2098,928,'2012-02-15','09:29:05','1200.000000',NULL,NULL,NULL,NULL,'0.000000',NULL,NULL,'1200.000000',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'C',NULL,NULL,'S','3611cc3585239a46de8be90bba26318a',0);

/*Table structure for table `ecf_venda_detalhe` */

DROP TABLE IF EXISTS `ecf_venda_detalhe`;

CREATE TABLE `ecf_venda_detalhe` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `ID_ECF_PRODUTO` int(10) unsigned NOT NULL,
  `ID_ECF_VENDA_CABECALHO` int(10) unsigned NOT NULL,
  `CFOP` int(10) unsigned DEFAULT NULL,
  `ITEM` int(10) unsigned DEFAULT NULL,
  `QUANTIDADE` decimal(20,6) DEFAULT NULL,
  `VALOR_UNITARIO` decimal(20,6) DEFAULT NULL,
  `VALOR_TOTAL` decimal(20,6) DEFAULT NULL,
  `TOTAL_ITEM` decimal(20,6) DEFAULT NULL,
  `BASE_ICMS` decimal(20,6) DEFAULT NULL,
  `TAXA_ICMS` decimal(20,6) DEFAULT NULL,
  `ICMS` decimal(20,6) DEFAULT NULL,
  `TAXA_DESCONTO` decimal(20,6) DEFAULT NULL,
  `DESCONTO` decimal(20,6) DEFAULT NULL,
  `TAXA_ISSQN` decimal(20,6) unsigned zerofill DEFAULT NULL,
  `ISSQN` decimal(20,6) DEFAULT NULL,
  `TAXA_PIS` decimal(20,6) DEFAULT NULL,
  `PIS` decimal(20,6) DEFAULT NULL,
  `TAXA_COFINS` decimal(20,6) DEFAULT NULL,
  `COFINS` decimal(20,6) DEFAULT NULL,
  `TAXA_ACRESCIMO` decimal(20,6) DEFAULT NULL,
  `ACRESCIMO` decimal(20,6) DEFAULT NULL,
  `ACRESCIMO_RATEIO` decimal(20,6) DEFAULT NULL,
  `DESCONTO_RATEIO` decimal(20,6) DEFAULT NULL,
  `TOTALIZADOR_PARCIAL` varchar(10) DEFAULT NULL,
  `CST` char(3) DEFAULT NULL,
  `CANCELADO` char(1) DEFAULT NULL,
  `MOVIMENTA_ESTOQUE` char(1) DEFAULT NULL,
  `GTIN` varchar(14) DEFAULT NULL,
  `CCF` int(10) unsigned DEFAULT NULL,
  `COO` int(10) unsigned DEFAULT NULL,
  `SERIE_ECF` varchar(20) DEFAULT NULL,
  `ECF_ICMS_ST` varchar(4) DEFAULT NULL,
  `HASH_TRIPA` varchar(32) DEFAULT NULL,
  `HASH_INCREMENTO` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_VENDA_CAB_DET` (`ID_ECF_VENDA_CABECALHO`),
  KEY `FK_PRODUTO_VENDA_DET` (`ID_ECF_PRODUTO`),
  CONSTRAINT `ecf_venda_detalhe_ibfk_1` FOREIGN KEY (`ID_ECF_VENDA_CABECALHO`) REFERENCES `ecf_venda_cabecalho` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `ecf_venda_detalhe_ibfk_2` FOREIGN KEY (`ID_ECF_PRODUTO`) REFERENCES `produto` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `ecf_venda_detalhe` */

insert  into `ecf_venda_detalhe`(`ID`,`ID_ECF_PRODUTO`,`ID_ECF_VENDA_CABECALHO`,`CFOP`,`ITEM`,`QUANTIDADE`,`VALOR_UNITARIO`,`VALOR_TOTAL`,`TOTAL_ITEM`,`BASE_ICMS`,`TAXA_ICMS`,`ICMS`,`TAXA_DESCONTO`,`DESCONTO`,`TAXA_ISSQN`,`ISSQN`,`TAXA_PIS`,`PIS`,`TAXA_COFINS`,`COFINS`,`TAXA_ACRESCIMO`,`ACRESCIMO`,`ACRESCIMO_RATEIO`,`DESCONTO_RATEIO`,`TOTALIZADOR_PARCIAL`,`CST`,`CANCELADO`,`MOVIMENTA_ESTOQUE`,`GTIN`,`CCF`,`COO`,`SERIE_ECF`,`ECF_ICMS_ST`,`HASH_TRIPA`,`HASH_INCREMENTO`) values (1,5,1,5102,1,'1.000000','120.000000','120.000000','120.000000','120.000000','12.000000','14.400000',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'03T1200','000','N','S','0001190000009',926,2095,'DR0510BR000000228007','1200','a2de75caee0a0594ef2cd7ed6191324b',0),(2,1,2,5102,1,'1.000000','10.000000','10.000000','10.000000','10.000000','7.000000','0.700000',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'04T0700','000','N','S','3011010827133',927,2096,'DR0510BR000000228007','0700','495e09bac49dccc14f8e5326eeeba14d',0),(3,3,3,5102,1,'1.000000','1200.000000','1200.000000','1200.000000','1200.000000','0.000000','0.000000',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'01S0500','090','N','S','0001170000005',928,2098,'DR0510BR000000228007','0500','468538e74c00e439d779c1c67c0c717c',0);

/*Table structure for table `ficha_tecnica` */

DROP TABLE IF EXISTS `ficha_tecnica`;

CREATE TABLE `ficha_tecnica` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `ID_PRODUTO` int(10) unsigned NOT NULL,
  `DESCRICAO` varchar(50) DEFAULT NULL,
  `ID_PRODUTO_FILHO` int(10) unsigned DEFAULT NULL,
  `QUANTIDADE` decimal(20,6) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_PRODUTO_FICHA_TECNICA` (`ID_PRODUTO`),
  CONSTRAINT `ficha_tecnica_ibfk_1` FOREIGN KEY (`ID_PRODUTO`) REFERENCES `produto` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `ficha_tecnica` */

/*Table structure for table `nfe_cabecalho` */

DROP TABLE IF EXISTS `nfe_cabecalho`;

CREATE TABLE `nfe_cabecalho` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `ID_VENDA_CABECALHO` int(10) unsigned NOT NULL,
  `ID_PEDIDO_COMPRA` int(10) unsigned DEFAULT NULL,
  `ID_CLIENTE` int(10) unsigned DEFAULT NULL,
  `ID_FUNCIONARIO` int(10) unsigned DEFAULT NULL,
  `CODIGO_NUMERICO` varchar(8) DEFAULT NULL,
  `NATUREZA_OPERACAO` varchar(60) DEFAULT NULL,
  `INDICADOR_FORMA_PAGAMENTO` char(1) DEFAULT NULL,
  `CODIGO_MODELO` char(2) DEFAULT NULL,
  `SERIE` char(3) DEFAULT NULL,
  `NUMERO` varchar(9) DEFAULT NULL,
  `DATA_EMISSAO` date DEFAULT NULL,
  `DATA_ENTRADA_SAIDA` date DEFAULT NULL,
  `HORA_ENTRADA_SAIDA` varchar(8) DEFAULT NULL,
  `TIPO_OPERACAO` char(1) DEFAULT NULL,
  `CODIGO_MUNICIPIO` int(10) unsigned DEFAULT NULL,
  `FORMATO_IMPRESSAO_DANFE` char(1) DEFAULT NULL,
  `TIPO_EMISSAO` char(1) DEFAULT NULL,
  `CHAVE_ACESSO` varchar(44) DEFAULT NULL,
  `DIGITO_CHAVE_ACESSO` char(1) DEFAULT NULL,
  `AMBIENTE` char(1) DEFAULT NULL,
  `FINALIDADE_EMISSAO` char(1) DEFAULT NULL,
  `PROCESSO_EMISSAO` char(1) DEFAULT NULL,
  `VERSAO_PROCESSO_EMISSAO` int(10) unsigned DEFAULT NULL,
  `BASE_CALCULO_ICMS` decimal(18,6) DEFAULT NULL,
  `VALOR_ICMS` decimal(18,6) DEFAULT NULL,
  `BASE_CALCULO_ICMS_ST` decimal(18,6) DEFAULT NULL,
  `VALOR_ICMS_ST` decimal(18,6) DEFAULT NULL,
  `VALOR_TOTAL_PRODUTOS` decimal(18,6) DEFAULT NULL,
  `VALOR_FRETE` decimal(18,6) DEFAULT NULL,
  `VALOR_SEGURO` decimal(18,6) DEFAULT NULL,
  `VALOR_DESCONTO` decimal(18,6) DEFAULT NULL,
  `VALOR_IMPOSTO_IMPORTACAO` decimal(18,6) DEFAULT NULL,
  `VALOR_IPI` decimal(18,6) DEFAULT NULL,
  `VALOR_PIS` decimal(18,6) DEFAULT NULL,
  `VALOR_COFINS` decimal(18,6) DEFAULT NULL,
  `VALOR_DESPESAS_ACESSORIAS` decimal(18,6) DEFAULT NULL,
  `VALOR_TOTAL` decimal(18,6) DEFAULT NULL,
  `VALOR_SERVICOS` decimal(18,6) DEFAULT NULL,
  `BASE_CALCULO_ISSQN` decimal(18,6) DEFAULT NULL,
  `VALOR_ISSQN` decimal(18,6) DEFAULT NULL,
  `VALOR_PIS_ISSQN` decimal(18,6) DEFAULT NULL,
  `VALOR_COFINS_ISSQN` decimal(18,6) DEFAULT NULL,
  `VALOR_RETIDO_PIS` decimal(18,6) DEFAULT NULL,
  `VALOR_RETIDO_COFINS` decimal(18,6) DEFAULT NULL,
  `VALOR_RETIDO_CSLL` decimal(18,6) DEFAULT NULL,
  `BASE_CALCULO_IRRF` decimal(18,6) DEFAULT NULL,
  `VALOR_RETIDO_IRRF` decimal(18,6) DEFAULT NULL,
  `BASE_CALCULO_PREVIDENCIA` decimal(18,6) DEFAULT NULL,
  `VALOR_RETIDO_PREVIDENCIA` decimal(18,6) DEFAULT NULL,
  `UF_EMBARQUE` char(2) DEFAULT NULL,
  `LOCAL_EMBARQUE` varchar(60) DEFAULT NULL,
  `NOTA_EMPENHO` varchar(17) DEFAULT NULL,
  `PEDIDO` varchar(60) DEFAULT NULL,
  `ISS_RETIDO` char(1) DEFAULT NULL,
  `INFORMACOES_ADD_FISCO` text,
  `INFORMACOES_ADD_CONTRIBUINTE` text,
  `INFORMACOES_COMPLEMENTARES` text,
  PRIMARY KEY (`ID`),
  KEY `NFE_CABECALHO_FKIndex1` (`ID_VENDA_CABECALHO`),
  CONSTRAINT `nfe_cabecalho_ibfk_1` FOREIGN KEY (`ID_VENDA_CABECALHO`) REFERENCES `ecf_venda_cabecalho` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `nfe_cabecalho` */

/*Table structure for table `nfe_configuracao` */

DROP TABLE IF EXISTS `nfe_configuracao`;

CREATE TABLE `nfe_configuracao` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `CERTIFICADO_DIGITAL` varchar(20) DEFAULT NULL,
  `CAMINHO_CERTIFICADO` varchar(80) DEFAULT NULL,
  `SENHA_CERTIFICADO` varchar(15) DEFAULT NULL,
  `FORMATO_IMPRESSAO_DANFE` char(1) DEFAULT NULL,
  `LOGOMARCA` varchar(80) DEFAULT NULL,
  `CAMINHO_SALVAR_XML` varchar(80) DEFAULT NULL,
  `SALVA_XML` char(1) DEFAULT NULL,
  `FONTE_ATT` int(10) unsigned DEFAULT NULL,
  `FONTE_OUTROS_CAMPOS` int(10) unsigned DEFAULT NULL,
  `FONTE_RAZAO_SOCIAL` int(10) unsigned DEFAULT NULL,
  `IMPRIMIR_DETALHE_ESPECIFICO` int(10) unsigned DEFAULT NULL,
  `UF_WEBSERVICE` char(2) DEFAULT NULL,
  `AMBIENTE` char(1) DEFAULT NULL,
  `NOME_HOST` varchar(30) DEFAULT NULL,
  `PORTA` int(10) unsigned DEFAULT NULL,
  `USUARIO` varchar(60) DEFAULT NULL,
  `SENHA` varchar(20) DEFAULT NULL,
  `ASSUNTO` varchar(80) DEFAULT NULL,
  `AUTENTICA_SSL` char(1) DEFAULT NULL,
  `PROXY_HOST` varchar(80) DEFAULT NULL,
  `PROXY_PORTA` varchar(6) DEFAULT NULL,
  `PROXY_USER` varchar(60) DEFAULT NULL,
  `PROXY_SENHA` varchar(20) DEFAULT NULL,
  `IMPRIMIR_USUARIO_RODAPE` char(1) DEFAULT NULL,
  `TEXTO_EMAIL` text,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `nfe_configuracao` */

/*Table structure for table `nfe_cupom_fiscal` */

DROP TABLE IF EXISTS `nfe_cupom_fiscal`;

CREATE TABLE `nfe_cupom_fiscal` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `ID_NFE_CABECALHO` int(10) unsigned NOT NULL,
  `MODELO_DOCUMENTO_FISCAL` char(2) DEFAULT NULL,
  `DATA_EMISSAO_CUPOM` date DEFAULT NULL,
  `NUMERO_ORDEM_ECF` int(10) unsigned DEFAULT NULL,
  `COO` int(10) unsigned DEFAULT NULL,
  `NUMERO_CAIXA` int(10) unsigned DEFAULT NULL,
  `NUMERO_SERIE_ECF` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_NFE_CUPOM_FISCAL` (`ID_NFE_CABECALHO`),
  KEY `NFE_CUPOM_FISCAL_FKIndex1` (`ID_NFE_CABECALHO`),
  CONSTRAINT `nfe_cupom_fiscal_ibfk_1` FOREIGN KEY (`ID_NFE_CABECALHO`) REFERENCES `nfe_cabecalho` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `nfe_cupom_fiscal` */

/*Table structure for table `nfe_detalhe` */

DROP TABLE IF EXISTS `nfe_detalhe`;

CREATE TABLE `nfe_detalhe` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `ID_PRODUTO` int(10) unsigned NOT NULL,
  `ID_NFE_CABECALHO` int(10) unsigned NOT NULL,
  `NUMERO_ITEM` int(10) unsigned DEFAULT NULL,
  `CODIGO_PRODUTO` varchar(60) DEFAULT NULL,
  `GTIN` varchar(14) DEFAULT NULL,
  `NOME_PRODUTO` varchar(100) DEFAULT NULL,
  `NCM` varchar(8) DEFAULT NULL,
  `EX_TIPI` int(10) unsigned DEFAULT NULL,
  `CFOP` int(10) unsigned DEFAULT NULL,
  `UNIDADE_COMERCIAL` varchar(6) DEFAULT NULL,
  `QUANTIDADE_COMERCIAL` decimal(18,6) DEFAULT NULL,
  `VALOR_UNITARIO_COMERCIAL` decimal(18,6) DEFAULT NULL,
  `VALOR_BRUTO_PRODUTOS` decimal(18,6) DEFAULT NULL,
  `GTIN_UNIDADE_TRIBUTAVEL` varchar(14) DEFAULT NULL,
  `UNIDADE_TRIBUTAVEL` varchar(6) DEFAULT NULL,
  `QUANTIDADE_TRIBUTAVEL` decimal(18,6) DEFAULT NULL,
  `VALOR_UNITARIO_TRIBUTACAO` decimal(18,6) DEFAULT NULL,
  `VALOR_FRETE` decimal(18,6) DEFAULT NULL,
  `VALOR_SEGURO` decimal(18,6) DEFAULT NULL,
  `VALOR_DESCONTO` decimal(18,6) DEFAULT NULL,
  `VALOR_OUTRAS_DESPESAS` decimal(18,6) DEFAULT NULL,
  `ENTRA_TOTAL` char(1) DEFAULT NULL,
  `ORIGEM_MERCADORIA` char(1) DEFAULT NULL,
  `CST_ICMS` char(3) DEFAULT NULL,
  `CSOSN` char(4) DEFAULT NULL,
  `MODALIDADE_BC_ICMS` char(1) DEFAULT NULL,
  `TAXA_REDUCAO_BC_ICMS` decimal(18,6) DEFAULT NULL,
  `BASE_CALCULO_ICMS` decimal(18,6) DEFAULT NULL,
  `ALIQUOTA_ICMS` decimal(18,6) DEFAULT NULL,
  `VALOR_ICMS` decimal(18,6) DEFAULT NULL,
  `MOTIVO_DESONERACAO_ICMS` char(1) DEFAULT NULL,
  `MODALIDE_BC_ICMS_ST` char(1) DEFAULT NULL,
  `PERCENTUAL_MVA_ICMS_ST` decimal(18,6) DEFAULT NULL,
  `REDUCAO_BC_ICMS_ST` decimal(18,6) DEFAULT NULL,
  `BASE_CALCULO_ICMS_ST` decimal(18,6) DEFAULT NULL,
  `ALIQUOTA_ICMS_ST` decimal(18,6) DEFAULT NULL,
  `VALOR_ICMS_ST` decimal(18,6) DEFAULT NULL,
  `VALOR_BC_ICMS_ST_RETIDO` decimal(18,6) DEFAULT NULL,
  `VALOR_ICMS_ST_RETIDO` decimal(18,6) DEFAULT NULL,
  `ALIQUOTA_CREDITO_ICMS_SN` decimal(18,6) DEFAULT NULL,
  `VALOR_CREDITO_ICMS_SN` decimal(18,6) DEFAULT NULL,
  `ENQUADRAMENTO_IPI` varchar(5) DEFAULT NULL,
  `CNPJ_PRODUTOR` varchar(14) DEFAULT NULL,
  `CODIGO_SELO_IPI` varchar(60) DEFAULT NULL,
  `QUANTIDADE_SELO_IPI` int(10) unsigned DEFAULT NULL,
  `ENQUADRAMENTO_LEGAL_IPI` char(3) DEFAULT NULL,
  `CST_IPI` char(2) DEFAULT NULL,
  `BASE_CALCULO_IPI` decimal(18,6) DEFAULT NULL,
  `ALIQUOTA_IPI` decimal(18,6) DEFAULT NULL,
  `VALOR_IPI` decimal(18,6) DEFAULT NULL,
  `VALOR_BC_II` decimal(18,6) DEFAULT NULL,
  `VALOR_DESPESAS_ADUANEIRAS` decimal(18,6) DEFAULT NULL,
  `VALOR_IMPOSTO_IMPORTACAO` decimal(18,6) DEFAULT NULL,
  `VALOR_IOF` decimal(18,6) DEFAULT NULL,
  `CTS_PIS` char(2) DEFAULT NULL,
  `VALOR_BASE_CALCULO_PIS` decimal(18,6) DEFAULT NULL,
  `ALIQUOTA_PIS_PERCENTUAL` decimal(18,6) DEFAULT NULL,
  `ALIQUOTA_PIS_REAIS` decimal(18,6) DEFAULT NULL,
  `VALOR_PIS` decimal(18,6) DEFAULT NULL,
  `CST_COFINS` char(2) DEFAULT NULL,
  `BASE_CALCULO_COFINS` decimal(18,6) DEFAULT NULL,
  `ALIQUOTA_COFINS_PERCENTUAL` decimal(18,6) DEFAULT NULL,
  `ALIQUOTA_COFINS_REAIS` decimal(18,6) DEFAULT NULL,
  `VALOR_COFINS` decimal(18,6) DEFAULT NULL,
  `BASE_CALCULO_ISSQN` decimal(18,6) DEFAULT NULL,
  `ALIQUOTA_ISSQN` decimal(18,6) DEFAULT NULL,
  `VALOR_ISSQN` decimal(18,6) DEFAULT NULL,
  `MUNICIPIO_ISSQN` int(10) unsigned DEFAULT NULL,
  `ITEM_LISTA_SERVICOS` int(10) unsigned DEFAULT NULL,
  `TRIBUTACAO_ISSQN` char(1) DEFAULT NULL,
  `VALOR_SUBTOTAL` decimal(18,6) DEFAULT NULL,
  `VALOR_TOTAL` decimal(18,6) DEFAULT NULL,
  `INFORMACOES_ADICIONAIS` text,
  PRIMARY KEY (`ID`),
  KEY `FK_NFE_CAB_DET` (`ID_NFE_CABECALHO`),
  KEY `NFE_DETALHE_FKIndex1` (`ID_NFE_CABECALHO`),
  KEY `NFE_DETALHE_FKIndex2` (`ID_PRODUTO`),
  CONSTRAINT `nfe_detalhe_ibfk_1` FOREIGN KEY (`ID_NFE_CABECALHO`) REFERENCES `nfe_cabecalho` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `nfe_detalhe_ibfk_2` FOREIGN KEY (`ID_PRODUTO`) REFERENCES `produto` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `nfe_detalhe` */

/*Table structure for table `nota_fiscal_cabecalho` */

DROP TABLE IF EXISTS `nota_fiscal_cabecalho`;

CREATE TABLE `nota_fiscal_cabecalho` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `ID_ECF_FUNCIONARIO` int(10) unsigned NOT NULL,
  `ID_CLIENTE` int(10) unsigned NOT NULL,
  `CFOP` int(10) unsigned DEFAULT NULL,
  `NUMERO` varchar(6) DEFAULT NULL,
  `DATA_EMISSAO` date DEFAULT NULL,
  `HORA_EMISSAO` varchar(8) DEFAULT NULL,
  `SERIE` char(2) DEFAULT NULL,
  `SUBSERIE` char(2) DEFAULT NULL,
  `TOTAL_PRODUTOS` decimal(20,6) DEFAULT NULL,
  `TOTAL_NF` decimal(20,6) DEFAULT NULL,
  `BASE_ICMS` decimal(20,6) DEFAULT NULL,
  `ICMS` decimal(20,6) DEFAULT NULL,
  `ICMS_OUTRAS` decimal(20,6) DEFAULT NULL,
  `ISSQN` decimal(20,6) DEFAULT NULL,
  `PIS` decimal(20,6) DEFAULT NULL,
  `COFINS` decimal(20,6) DEFAULT NULL,
  `IPI` decimal(20,6) DEFAULT NULL,
  `TAXA_ACRESCIMO` decimal(20,6) DEFAULT NULL,
  `ACRESCIMO` decimal(20,6) DEFAULT NULL,
  `ACRESCIMO_ITENS` decimal(20,6) DEFAULT NULL,
  `TAXA_DESCONTO` decimal(20,6) DEFAULT NULL,
  `DESCONTO` decimal(20,6) DEFAULT NULL,
  `DESCONTO_ITENS` decimal(20,6) DEFAULT NULL,
  `CANCELADA` char(1) DEFAULT NULL,
  `SINCRONIZADO` char(1) DEFAULT NULL,
  `TIPO_NOTA` char(1) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_CLIENTE_NF2` (`ID_CLIENTE`),
  KEY `FK_VENDEDOR_NF2` (`ID_ECF_FUNCIONARIO`),
  CONSTRAINT `nota_fiscal_cabecalho_ibfk_1` FOREIGN KEY (`ID_CLIENTE`) REFERENCES `cliente` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `nota_fiscal_cabecalho_ibfk_2` FOREIGN KEY (`ID_ECF_FUNCIONARIO`) REFERENCES `ecf_funcionario` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `nota_fiscal_cabecalho` */

/*Table structure for table `nota_fiscal_detalhe` */

DROP TABLE IF EXISTS `nota_fiscal_detalhe`;

CREATE TABLE `nota_fiscal_detalhe` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `ID_NF_CABECALHO` int(10) unsigned NOT NULL,
  `ID_PRODUTO` int(10) unsigned NOT NULL,
  `CFOP` int(10) unsigned DEFAULT NULL,
  `ITEM` int(10) unsigned DEFAULT NULL,
  `QUANTIDADE` decimal(20,6) DEFAULT NULL,
  `VALOR_UNITARIO` decimal(20,6) DEFAULT NULL,
  `VALOR_TOTAL` decimal(20,6) DEFAULT NULL,
  `BASE_ICMS` decimal(20,6) DEFAULT NULL,
  `TAXA_ICMS` decimal(20,6) DEFAULT NULL,
  `ICMS` decimal(20,6) DEFAULT NULL,
  `ICMS_OUTRAS` decimal(20,6) DEFAULT NULL,
  `ICMS_ISENTO` decimal(20,6) DEFAULT NULL,
  `TAXA_DESCONTO` decimal(20,6) DEFAULT NULL,
  `DESCONTO` decimal(20,6) DEFAULT NULL,
  `TAXA_ISSQN` decimal(20,6) DEFAULT NULL,
  `ISSQN` decimal(20,6) DEFAULT NULL,
  `TAXA_PIS` decimal(20,6) DEFAULT NULL,
  `PIS` decimal(20,6) DEFAULT NULL,
  `TAXA_COFINS` decimal(20,6) DEFAULT NULL,
  `COFINS` decimal(20,6) DEFAULT NULL,
  `TAXA_ACRESCIMO` decimal(20,6) DEFAULT NULL,
  `ACRESCIMO` decimal(20,6) DEFAULT NULL,
  `TAXA_IPI` decimal(20,6) DEFAULT NULL,
  `IPI` decimal(20,6) DEFAULT NULL,
  `CANCELADO` char(1) DEFAULT NULL,
  `MOVIMENTA_ESTOQUE` char(1) DEFAULT NULL,
  `SINCRONIZADO` char(1) DEFAULT NULL,
  `CST` char(3) DEFAULT NULL,
  `ECF_ICMS_ST` varchar(4) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_NF2_CAB_DET` (`ID_NF_CABECALHO`),
  KEY `FK_PRODUTO_NF2_DET` (`ID_PRODUTO`),
  CONSTRAINT `nota_fiscal_detalhe_ibfk_1` FOREIGN KEY (`ID_NF_CABECALHO`) REFERENCES `nota_fiscal_cabecalho` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `nota_fiscal_detalhe_ibfk_2` FOREIGN KEY (`ID_PRODUTO`) REFERENCES `produto` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `nota_fiscal_detalhe` */

/*Table structure for table `produto` */

DROP TABLE IF EXISTS `produto`;

CREATE TABLE `produto` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `ID_UNIDADE_PRODUTO` int(10) unsigned NOT NULL,
  `GTIN` varchar(14) DEFAULT NULL,
  `CODIGO_INTERNO` varchar(20) DEFAULT NULL,
  `NOME` varchar(100) DEFAULT NULL,
  `DESCRICAO` text,
  `DESCRICAO_PDV` varchar(30) DEFAULT NULL,
  `VALOR_VENDA` decimal(20,6) DEFAULT NULL,
  `QTD_ESTOQUE` decimal(20,6) DEFAULT NULL,
  `QTD_ESTOQUE_ANTERIOR` decimal(20,6) DEFAULT NULL,
  `ESTOQUE_MIN` decimal(20,6) DEFAULT NULL,
  `ESTOQUE_MAX` decimal(20,6) DEFAULT NULL,
  `IAT` char(1) DEFAULT NULL,
  `IPPT` char(1) DEFAULT NULL,
  `NCM` varchar(8) DEFAULT NULL,
  `TIPO_ITEM_SPED` char(2) DEFAULT NULL,
  `DATA_ESTOQUE` date DEFAULT NULL,
  `HORA_ESTOQUE` varchar(8) DEFAULT NULL,
  `TAXA_IPI` decimal(20,6) DEFAULT NULL,
  `TAXA_ISSQN` decimal(20,6) DEFAULT NULL,
  `TAXA_PIS` decimal(20,6) DEFAULT NULL,
  `TAXA_COFINS` decimal(20,6) DEFAULT NULL,
  `TAXA_ICMS` decimal(20,6) DEFAULT NULL,
  `CST` char(3) DEFAULT NULL,
  `CSOSN` char(4) DEFAULT NULL,
  `TOTALIZADOR_PARCIAL` varchar(10) DEFAULT NULL,
  `ECF_ICMS_ST` varchar(4) DEFAULT NULL,
  `CODIGO_BALANCA` int(10) unsigned DEFAULT NULL,
  `PAF_P_ST` char(1) DEFAULT NULL,
  `HASH_TRIPA` varchar(32) DEFAULT NULL,
  `HASH_INCREMENTO` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_UNIDADE_PRODUTO` (`ID_UNIDADE_PRODUTO`),
  CONSTRAINT `produto_ibfk_1` FOREIGN KEY (`ID_UNIDADE_PRODUTO`) REFERENCES `unidade_produto` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=latin1;

/*Data for the table `produto` */

insert  into `produto`(`ID`,`ID_UNIDADE_PRODUTO`,`GTIN`,`CODIGO_INTERNO`,`NOME`,`DESCRICAO`,`DESCRICAO_PDV`,`VALOR_VENDA`,`QTD_ESTOQUE`,`QTD_ESTOQUE_ANTERIOR`,`ESTOQUE_MIN`,`ESTOQUE_MAX`,`IAT`,`IPPT`,`NCM`,`TIPO_ITEM_SPED`,`DATA_ESTOQUE`,`HORA_ESTOQUE`,`TAXA_IPI`,`TAXA_ISSQN`,`TAXA_PIS`,`TAXA_COFINS`,`TAXA_ICMS`,`CST`,`CSOSN`,`TOTALIZADOR_PARCIAL`,`ECF_ICMS_ST`,`CODIGO_BALANCA`,`PAF_P_ST`,`HASH_TRIPA`,`HASH_INCREMENTO`) values (1,1,'3011010827133','30113','01 PRODUTO TRIBUTADO A 7%','01 PRODUTO TRIBUTADO A 7%','01 PRODUTO TRIBUTADO A 7%','10.000000','-140.000000','-140.000000','10.000000','1000.000000','A','T','40129010','04','2012-02-15','09:28:31',NULL,NULL,NULL,NULL,'7.000000','000','1900','04T0700','07',NULL,'T','fe9bd06027fc11f6e6dc0d6fbfed6062',0),(2,1,'0312011604499','03129','02 PRODUTO TRIBUTADO A 7%','02 PRODUTO TRIBUTADO A 7%','02 PRODUTO TRIBUTADO A 7%','35.000000','48.000000','48.000000','10.000000','1000.000000','A','T','40129010','04','2012-02-15','09:28:31',NULL,NULL,NULL,NULL,'7.000000','000','1900','04T0700','07',NULL,'T','954ab9f32d8baadfadaddb6b0a8e7edd',0),(3,2,'0001170000005','00015','01 SERVICO TRIBUTADO A 5%','01 SERVICO TRIBUTADO A 5%','01 SERVICO TRIBUTADO A 5%','1200.000000','29.000000','29.000000','10.000000','1000.000000','A','T','40129010','04','2012-02-15','09:28:31',NULL,'5.000000',NULL,NULL,'0.000000','090','1900','01S0500','05',NULL,'S','62b7c2fecd849db36a862665423abdac',0),(4,2,'0001180000002','00012','SERVICO TRIBUTADO A 3%','SERVICO TRIBUTADO A 3%','SERVICO TRIBUTADO A 3%','558.000000','49.000000','49.000000','10.000000','1000.000000','A','T','40129010','04','2012-02-15','09:28:31',NULL,'3.000000',NULL,NULL,'0.000000','090','1900','02S0300','03',NULL,'S','22749e82c320022abee569bdf2389219',0),(5,3,'0001190000009','00019','01 PRODUTO TIBUTADO A 12%','01 PRODUTO TIBUTADO A 12%','01 PRODUTO TIBUTADO A 12%','120.000000','39.000000','40.000000','10.000000','1000.000000','A','T','40129010','04','2012-02-15','09:28:31',NULL,NULL,NULL,NULL,'12.000000','000','1900','03T1200','12',NULL,'T','6b1d26a9f5c3638a74d9a46c23853452',0),(6,4,'0001234567898','00018','PRODUTO TRIBUTADO A 17%','PRODUTO TRIBUTADO A 17%','PRODUTO TRIBUTADO A 17%','5.800000','29.000000','29.000000','10.000000','1000.000000','A','T','40129010','04','2012-02-15','09:28:31',NULL,NULL,NULL,NULL,'17.000000','000','1900','05T1700','17',NULL,'T','71f832464770b37c99550702d2b64ebc',0),(7,5,'0407011150500','04070','PRODUTO TRIBUTADO A 25%','PRODUTO TRIBUTADO A 25%','PRODUTO TRIBUTADO A 25%','29.800000','29.000000','29.000000','10.000000','1000.000000','A','T','40129010','04','2012-02-15','09:28:31',NULL,NULL,NULL,NULL,'25.000000','000','1900','02T2500','25',NULL,'T','f6bbd758022e89dc92b1a2580344b9b7',0),(8,6,'1603041234428','16038','PRODUTO ISENTO','PRODUTO ISENTO','PRODUTO ISENTO','120.000000','44.000000','44.000000','10.000000','1000.000000','A','T','40129010','04','2012-02-15','09:28:31',NULL,NULL,NULL,NULL,'0.000000','040','1900','I1','II',NULL,'I','2e268c3e58a55205e65a0f65040acc82',0),(9,7,'0507021132142','05072','PRODUTO SUBSTITUICAO TRIBUTARIA','PRODUTO SUBSTITUICAO TRIBUTARIA','PRODUTO SUBSTITUICAO TRIBUTARI','30.000000','29.000000','29.000000','10.000000','1000.000000','A','T','40129010','04','2012-02-15','09:28:31',NULL,NULL,NULL,NULL,'0.000000','010','1900','F1','FF',NULL,'F','e196498671b26b14b139811a74e04613',0),(10,1,'2509021501148','25098','PRODUTO NAO TRIBUTADO','PRODUTO NAO TRIBUTADO','PRODUTO NAO TRIBUTADO','558.000000','49.000000','49.000000','10.000000','1000.000000','A','T','40129010','04','2012-02-15','09:28:31',NULL,NULL,NULL,NULL,'0.000000','041','1900','N1','NN',NULL,'N','691003b41bd77174e946cc6bfa34071a',0),(11,2,'2608021532487','26087','02 PRODUTO TIBUTADO A 12%','02 PRODUTO TIBUTADO A 12%','02 PRODUTO TIBUTADO A 12%','30.000000','49.000000','49.000000','10.000000','1000.000000','A','T','40129010','04','2012-02-15','09:28:31',NULL,NULL,NULL,NULL,'12.000000','000','1900','03T1200','12',NULL,'T','ee4474eb1c32806668242744acfdad42',0),(12,2,'2106021651318','21068','02 SERVICO TRIBUTADO A 5%','02 SERVICO TRIBUTADO A 5%','02 SERVICO TRIBUTADO A 5%','700.000000','49.000000','49.000000','10.000000','1000.000000','A','T','40129010','04','2012-02-15','09:28:31',NULL,'5.000000',NULL,NULL,'0.000000','090','1900','01S0500','05',NULL,'S','729c5ff5e30ef1bdbf6251769fd30bb5',0),(13,1,'1234567894568','12348','PRODUTO PARA DAV POR 350','PRODUTO PARA DAV POR 350','PRODUTO PARA DAV POR 350','350.000000','99.000000','99.000000','10.000000','1000.000000','A','T','40129010','04','2012-02-15','09:28:31',NULL,NULL,NULL,NULL,'17.000000','000','1900','05T1700','17',NULL,'T','036bb8379222f9b36c247470eeb88a11',0),(14,1,'5488654654665','54885','PRODUTO PARA PRE VENDA POR 90','PRODUTO PARA PRE VENDA POR 90','PRODUTO PARA PRE VENDA POR 90','90.000000','99.000000','99.000000','10.000000','1000.000000','A','T','40129010','04','2012-02-15','09:28:31',NULL,NULL,NULL,NULL,'17.000000','000','1900','05T1700','17',NULL,'T','b6aa864cb25e849b46217a758b0dfb16',0),(15,1,'8797897998555','87985','PRODUTO PARA TESTE VALOR 200','PRODUTO PARA TESTE VALOR 200','PRODUTO PARA TESTE VALOR 200','200.000000','97.000000','97.000000','10.000000','1000.000000','A','T','40129010','04','2012-02-15','09:28:31',NULL,NULL,NULL,NULL,'17.000000','000','1900','05T1700','17',NULL,'T','05fb80611b4c72947acad963fe6142b8',0),(16,1,'5555554444564','55554','PRODUTO PARA TESTE VALOR 150','PRODUTO PARA TESTE VALOR 150','PRODUTO PARA TESTE VALOR 150','150.000000','99.000000','99.000000','10.000000','1000.000000','A','T','40129010','04','2012-02-15','09:28:31',NULL,NULL,NULL,NULL,'17.000000','000','1900','05T1700','17',NULL,'T','612ffaf523613b02d83b3a7f692359fb',0),(17,1,'6465487987999','64659','PRODUTO PARA TESTE VALOR 30','PRODUTO PARA TESTE VALOR 30','PRODUTO PARA TESTE VALOR 30','30.000000','99.000000','99.000000','10.000000','1000.000000','A','T','40129010','04','2012-02-15','09:28:31',NULL,NULL,NULL,NULL,'17.000000','000','1900','05T1700','17',NULL,'T','f01b1b1b5c26f83576a15d6e39062ce5',0),(18,1,'8521479787998','85218','PRODUTO PARA TESTE VALOR 500','PRODUTO PARA TESTE VALOR 500','PRODUTO PARA TESTE VALOR 500','500.000000','98.000000','98.000000','10.000000','1000.000000','A','T','40129010','04','2012-02-15','09:28:31',NULL,NULL,NULL,NULL,'17.000000','000','1900','05T1700','17',NULL,'T','89454e0b1cb2f7585747e3af3e5285d1',0),(19,1,'8798546521325','87985','PRODUTO PARA TESTE VALOR 50','PRODUTO PARA TESTE VALOR 50','PRODUTO PARA TESTE VALOR 50','50.000000','97.000000','97.000000','10.000000','1000.000000','A','T','40129010','04','2012-02-15','09:28:31',NULL,NULL,NULL,NULL,'17.000000','000','1900','05T1700','17',NULL,'T','14163bdcdac27dd073f086a1b661c541',0),(20,1,'2581473698888','25818','PRODUTO PARA TESTE VALOR 20','PRODUTO PARA TESTE VALOR 20','PRODUTO PARA TESTE VALOR 20','20.000000','97.000000','97.000000','10.000000','1000.000000','A','T','40129010','04','2012-02-15','09:28:31',NULL,NULL,NULL,NULL,'17.000000','000','1900','05T1700','17',NULL,'T','1dc4cbd01f40173ce9a99171d5e95a14',0),(21,1,'9876465431323','98763','PRODUTO PARA TESTE VALOR 140','PRODUTO PARA TESTE VALOR 140','PRODUTO PARA TESTE VALOR 140','140.000000','97.000000','97.000000','10.000000','1000.000000','A','T','40129010','04','2012-02-15','09:28:31',NULL,NULL,NULL,NULL,'17.000000','000','1900','05T1700','17',NULL,'T','1d505e64fa4bcd2be610714f1da44add',0),(23,1,'2548798532156','25486','PRODUTO DE PRODUCAO PROPRIA','PRODUTO DE PRODUCAO PROPRIA','PRODUTO DE PRODUCAO PROPRIA','10.000000','100.000000','100.000000','10.000000','1000.000000','A','P','40129010','04','2012-02-15','09:28:31',NULL,NULL,NULL,NULL,'17.000000','000','1900','05T1700','17',NULL,'T','7403e09cf04efa9ffa0c3a274133f082',0);

/*Table structure for table `produto_promocao` */

DROP TABLE IF EXISTS `produto_promocao`;

CREATE TABLE `produto_promocao` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `ID_PRODUTO` int(10) unsigned NOT NULL,
  `DATA_INICIO` date DEFAULT NULL,
  `DATA_FIM` date DEFAULT NULL,
  `QUANTIDADE_EM_PROMOCAO` decimal(20,6) DEFAULT NULL,
  `QUANTIDADE_MAXIMA_CLIENTE` decimal(20,6) DEFAULT NULL,
  `VALOR` decimal(20,6) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_PRODUTO_PROMOCAO` (`ID_PRODUTO`),
  CONSTRAINT `produto_promocao_ibfk_1` FOREIGN KEY (`ID_PRODUTO`) REFERENCES `produto` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `produto_promocao` */

/*Table structure for table `r01` */

DROP TABLE IF EXISTS `r01`;

CREATE TABLE `r01` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `SERIE_ECF` varchar(20) DEFAULT NULL,
  `CNPJ_EMPRESA` varchar(14) DEFAULT NULL,
  `CNPJ_SH` varchar(14) DEFAULT NULL,
  `INSCRICAO_ESTADUAL_SH` varchar(14) DEFAULT NULL,
  `INSCRICAO_MUNICIPAL_SH` varchar(14) DEFAULT NULL,
  `DENOMINACAO_SH` varchar(40) DEFAULT NULL,
  `NOME_PAF_ECF` varchar(40) DEFAULT NULL,
  `VERSAO_PAF_ECF` varchar(10) DEFAULT NULL,
  `MD5_PAF_ECF` varchar(32) DEFAULT NULL,
  `DATA_INICIAL` date DEFAULT NULL,
  `DATA_FINAL` date DEFAULT NULL,
  `VERSAO_ER` varchar(4) DEFAULT NULL,
  `NUMERO_LAUDO_PAF` varchar(40) DEFAULT NULL,
  `RAZAO_SOCIAL_SH` varchar(40) DEFAULT NULL,
  `ENDERECO_SH` varchar(40) DEFAULT NULL,
  `NUMERO_SH` varchar(10) DEFAULT NULL,
  `COMPLEMENTO_SH` varchar(40) DEFAULT NULL,
  `BAIRRO_SH` varchar(40) DEFAULT NULL,
  `CIDADE_SH` varchar(40) DEFAULT NULL,
  `CEP_SH` varchar(8) DEFAULT NULL,
  `UF_SH` char(2) DEFAULT NULL,
  `TELEFONE_SH` varchar(10) DEFAULT NULL,
  `CONTATO_SH` varchar(20) DEFAULT NULL,
  `PRINCIPAL_EXECUTAVEL` varchar(40) DEFAULT NULL,
  `HASH_TRIPA` varchar(32) DEFAULT NULL,
  `HASH_INCREMENTO` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `r01` */

insert  into `r01`(`ID`,`SERIE_ECF`,`CNPJ_EMPRESA`,`CNPJ_SH`,`INSCRICAO_ESTADUAL_SH`,`INSCRICAO_MUNICIPAL_SH`,`DENOMINACAO_SH`,`NOME_PAF_ECF`,`VERSAO_PAF_ECF`,`MD5_PAF_ECF`,`DATA_INICIAL`,`DATA_FINAL`,`VERSAO_ER`,`NUMERO_LAUDO_PAF`,`RAZAO_SOCIAL_SH`,`ENDERECO_SH`,`NUMERO_SH`,`COMPLEMENTO_SH`,`BAIRRO_SH`,`CIDADE_SH`,`CEP_SH`,`UF_SH`,`TELEFONE_SH`,`CONTATO_SH`,`PRINCIPAL_EXECUTAVEL`,`HASH_TRIPA`,`HASH_INCREMENTO`) values (1,'DR0206BR000000091632','10793118000178','10793118000178','0751990400114','0751990400114','T2TI TECNOLOGIA DA INFORMACAO LTDA','T2TI-PAFECF-Java','1.0','4892ACEE45107062C89CFBE2BC78A05',NULL,NULL,'0109','CUB0042011','T2TI TECNOLOGIA DA INFORMACAO LTDA','RUA DAS CARNAUBAS','4','SALA 304','AGUAS CLARAS','BRASILIA','71904540','DF','6130425277','CLAUDIO','T2TIPAFECFTEF.JAR','6fb63c1d8f36d09c890694406a579c79',0);

/*Table structure for table `r02` */

DROP TABLE IF EXISTS `r02`;

CREATE TABLE `r02` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `ID_OPERADOR` int(10) unsigned NOT NULL,
  `ID_IMPRESSORA` int(10) unsigned NOT NULL,
  `ID_ECF_CAIXA` int(10) unsigned DEFAULT NULL,
  `SERIE_ECF` varchar(20) DEFAULT NULL,
  `CRZ` int(10) unsigned DEFAULT NULL,
  `COO` int(10) unsigned DEFAULT NULL,
  `CRO` int(10) unsigned DEFAULT NULL,
  `DATA_MOVIMENTO` date DEFAULT NULL,
  `DATA_EMISSAO` date DEFAULT NULL,
  `HORA_EMISSAO` varchar(8) DEFAULT NULL,
  `VENDA_BRUTA` decimal(20,6) DEFAULT NULL,
  `GRANDE_TOTAL` decimal(20,6) DEFAULT NULL,
  `SINCRONIZADO` char(1) DEFAULT NULL,
  `HASH_TRIPA` varchar(32) DEFAULT NULL,
  `HASH_INCREMENTO` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `r02` */

insert  into `r02`(`ID`,`ID_OPERADOR`,`ID_IMPRESSORA`,`ID_ECF_CAIXA`,`SERIE_ECF`,`CRZ`,`COO`,`CRO`,`DATA_MOVIMENTO`,`DATA_EMISSAO`,`HORA_EMISSAO`,`VENDA_BRUTA`,`GRANDE_TOTAL`,`SINCRONIZADO`,`HASH_TRIPA`,`HASH_INCREMENTO`) values (1,1,1,1,'DR0510BR000000228007',132,2099,99,'2012-02-15','2012-02-15','09:29:38','1330.000000','389280.140000',NULL,'7b024c8f59e2fdcb04f50362b15a4bd8',0);

/*Table structure for table `r03` */

DROP TABLE IF EXISTS `r03`;

CREATE TABLE `r03` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `ID_R02` int(10) unsigned NOT NULL,
  `SERIE_ECF` varchar(20) DEFAULT NULL,
  `CRZ` int(10) unsigned DEFAULT NULL,
  `TOTALIZADOR_PARCIAL` varchar(10) DEFAULT NULL,
  `VALOR_ACUMULADO` decimal(20,6) DEFAULT NULL,
  `SINCRONIZADO` varchar(1) DEFAULT NULL,
  `HASH_TRIPA` varchar(32) DEFAULT NULL,
  `HASH_INCREMENTO` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_R02_R03` (`ID_R02`),
  CONSTRAINT `r03_ibfk_1` FOREIGN KEY (`ID_R02`) REFERENCES `r02` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;

/*Data for the table `r03` */

insert  into `r03`(`ID`,`ID_R02`,`SERIE_ECF`,`CRZ`,`TOTALIZADOR_PARCIAL`,`VALOR_ACUMULADO`,`SINCRONIZADO`,`HASH_TRIPA`,`HASH_INCREMENTO`) values (1,1,'DR0510BR000000228007',132,'01T1800','0.000000',NULL,'a9f47826bce5532f427d78fae870c98d',0),(2,1,'DR0510BR000000228007',132,'02T2500','0.000000',NULL,'a996403bf699ac26c2f684f5e8f44081',0),(3,1,'DR0510BR000000228007',132,'03T1200','120.000000',NULL,'5df5fb41ba3fb2c76d692829c95f8acd',0),(4,1,'DR0510BR000000228007',132,'04T0700','0.000000',NULL,'0a401d9cc879579ff311843c5982967d',0),(5,1,'DR0510BR000000228007',132,'05T1700','0.000000',NULL,'e6b10a4c939ba00a250342f63bcdd099',0),(6,1,'DR0510BR000000228007',132,'06S0500','0.000000',NULL,'ea5b788ac8ba21999781ddd3b05f5f0e',0),(7,1,'DR0510BR000000228007',132,'07S0300','0.000000',NULL,'bfc52c3c5f04d6c5384cef81cf956da0',0),(8,1,'DR0510BR000000228007',132,'F1','0.000000',NULL,'c9b7b201502db392758045a2968d0b39',0),(9,1,'DR0510BR000000228007',132,'I1','0.000000',NULL,'68bc4209416656703e725689f9858ba6',0),(10,1,'DR0510BR000000228007',132,'N1','0.000000',NULL,'a467a157c8a69787f6abe1ae680cee70',0),(11,1,'DR0510BR000000228007',132,'FS1','0.000000',NULL,'4cbcfcd01910e921bb9f7bf619925f1b',0),(12,1,'DR0510BR000000228007',132,'IS1','0.000000',NULL,'d9a1eca1a036ac824d5eef062c25b599',0),(13,1,'DR0510BR000000228007',132,'NS1','0.000000',NULL,'59afc6414294e949a02127379fae3c72',0),(14,1,'DR0510BR000000228007',132,'OPNF','0.000000',NULL,'58a6de242608579876ef886c2ca0b525',0),(15,1,'DR0510BR000000228007',132,'DT','0.000000',NULL,'1c6cbb481b3ebdc6c56ac7ad7ea85768',0),(16,1,'DR0510BR000000228007',132,'DS','0.000000',NULL,'172da71150a60187993b6af6aae6b855',0),(17,1,'DR0510BR000000228007',132,'AT','0.000000',NULL,'b1371afe3cf5b082a27e14e88e2a62d1',0),(18,1,'DR0510BR000000228007',132,'AS','0.000000',NULL,'17b6047c3c01b06ace5a406702dfbdea',0),(19,1,'DR0510BR000000228007',132,'Can-T','10.000000',NULL,'3845ba143985441ca93c184fa4db690f',0),(20,1,'DR0510BR000000228007',132,'Can-S','0.000000',NULL,'c1f324e5f8f5b008ff9950536128e709',0);

/*Table structure for table `r06` */

DROP TABLE IF EXISTS `r06`;

CREATE TABLE `r06` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `ID_OPERADOR` int(10) unsigned NOT NULL,
  `ID_IMPRESSORA` int(10) unsigned NOT NULL,
  `ID_ECF_CAIXA` int(10) unsigned DEFAULT NULL,
  `SERIE_ECF` varchar(20) DEFAULT NULL,
  `COO` int(10) unsigned DEFAULT NULL,
  `GNF` int(10) unsigned DEFAULT NULL,
  `GRG` int(10) unsigned DEFAULT NULL,
  `CDC` int(10) unsigned DEFAULT NULL,
  `DENOMINACAO` char(2) DEFAULT NULL,
  `DATA_EMISSAO` date DEFAULT NULL,
  `HORA_EMISSAO` varchar(8) DEFAULT NULL,
  `SINCRONIZADO` char(1) DEFAULT NULL,
  `HASH_TRIPA` varchar(32) DEFAULT NULL,
  `HASH_INCREMENTO` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `r06` */

insert  into `r06`(`ID`,`ID_OPERADOR`,`ID_IMPRESSORA`,`ID_ECF_CAIXA`,`SERIE_ECF`,`COO`,`GNF`,`GRG`,`CDC`,`DENOMINACAO`,`DATA_EMISSAO`,`HORA_EMISSAO`,`SINCRONIZADO`,`HASH_TRIPA`,`HASH_INCREMENTO`) values (1,1,1,1,'DR0510BR000000228007',2095,594,NULL,NULL,'RV','2012-02-15','09:28:30',NULL,'58e61f0cf2913ff35df32e49fffe4b3a',0),(2,1,1,1,'DR0510BR000000228007',2096,594,0,0,'RV','2012-02-15','09:28:51',NULL,'3215e2fd536c2c567b6903c25075cb95',0);

/*Table structure for table `r07` */

DROP TABLE IF EXISTS `r07`;

CREATE TABLE `r07` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `ID_R06` int(10) unsigned DEFAULT NULL,
  `CCF` int(10) unsigned DEFAULT NULL,
  `MEIO_PAGAMENTO` varchar(20) DEFAULT NULL,
  `VALOR_PAGAMENTO` decimal(20,6) DEFAULT NULL,
  `ESTORNO` char(1) DEFAULT NULL,
  `VALOR_ESTORNO` decimal(20,6) DEFAULT NULL,
  `SINCRONIZADO` char(1) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_R06_R07` (`ID_R06`),
  CONSTRAINT `r07_ibfk_1` FOREIGN KEY (`ID_R06`) REFERENCES `r06` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `r07` */

insert  into `r07`(`ID`,`ID_R06`,`CCF`,`MEIO_PAGAMENTO`,`VALOR_PAGAMENTO`,`ESTORNO`,`VALOR_ESTORNO`,`SINCRONIZADO`) values (1,NULL,NULL,'DINHEIRO','120.000000','N','0.000000',NULL),(2,NULL,NULL,'DINHEIRO','10.000000','N','0.000000',NULL);

/*Table structure for table `sintegra_60a` */

DROP TABLE IF EXISTS `sintegra_60a`;

CREATE TABLE `sintegra_60a` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `ID_SINTEGRA_60M` int(10) unsigned NOT NULL,
  `SITUACAO_TRIBUTARIA` varchar(4) DEFAULT NULL,
  `VALOR` decimal(20,6) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `SINTEGRA_60A_FKIndex1` (`ID_SINTEGRA_60M`),
  CONSTRAINT `sintegra_60a_ibfk_1` FOREIGN KEY (`ID_SINTEGRA_60M`) REFERENCES `sintegra_60m` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

/*Data for the table `sintegra_60a` */

insert  into `sintegra_60a`(`ID`,`ID_SINTEGRA_60M`,`SITUACAO_TRIBUTARIA`,`VALOR`) values (1,1,'18','0.000000'),(2,1,'25','0.000000'),(3,1,'12','120.000000'),(4,1,'7','0.000000'),(5,1,'17','0.000000'),(6,1,'5','0.000000'),(7,1,'3','0.000000'),(8,1,'F','0.000000'),(9,1,'I','0.000000'),(10,1,'N','0.000000'),(11,1,'DESC','0.000000'),(12,1,'CANC','10.000000');

/*Table structure for table `sintegra_60m` */

DROP TABLE IF EXISTS `sintegra_60m`;

CREATE TABLE `sintegra_60m` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `DATA_EMISSAO` date DEFAULT NULL,
  `NUMERO_SERIE_ECF` varchar(20) DEFAULT NULL,
  `NUMERO_EQUIPAMENTO` int(10) unsigned DEFAULT NULL,
  `MODELO_DOCUMENTO_FISCAL` char(2) DEFAULT NULL,
  `COO_INICIAL` int(10) unsigned DEFAULT NULL,
  `COO_FINAL` int(10) unsigned DEFAULT NULL,
  `CRZ` int(10) unsigned DEFAULT NULL,
  `CRO` int(10) unsigned DEFAULT NULL,
  `VALOR_VENDA_BRUTA` decimal(20,6) DEFAULT NULL,
  `VALOR_GRANDE_TOTAL` decimal(20,6) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `sintegra_60m` */

insert  into `sintegra_60m`(`ID`,`DATA_EMISSAO`,`NUMERO_SERIE_ECF`,`NUMERO_EQUIPAMENTO`,`MODELO_DOCUMENTO_FISCAL`,`COO_INICIAL`,`COO_FINAL`,`CRZ`,`CRO`,`VALOR_VENDA_BRUTA`,`VALOR_GRANDE_TOTAL`) values (1,'2012-02-15','DR0510BR000000228007',1,'2D',0,2099,132,99,'1330.000000','389280.140000');

/*Table structure for table `situacao_cliente` */

DROP TABLE IF EXISTS `situacao_cliente`;

CREATE TABLE `situacao_cliente` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `NOME` varchar(20) DEFAULT NULL,
  `DESCRICAO` text,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `situacao_cliente` */

insert  into `situacao_cliente`(`ID`,`NOME`,`DESCRICAO`) values (1,'Normal',NULL);

/*Table structure for table `unidade_produto` */

DROP TABLE IF EXISTS `unidade_produto`;

CREATE TABLE `unidade_produto` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `NOME` varchar(10) DEFAULT NULL,
  `PODE_FRACIONAR` char(1) DEFAULT NULL,
  `DESCRICAO` text,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

/*Data for the table `unidade_produto` */

insert  into `unidade_produto`(`ID`,`NOME`,`PODE_FRACIONAR`,`DESCRICAO`) values (1,'KG','S','KILO'),(2,'UND','N','UNIDADE'),(3,'MT','S','METRO'),(4,'M2','S','METRO QUADRADO'),(5,'M3','S','METRO CUBICO'),(6,'PCT','N','PACOTE'),(7,'CX','N','CAIXA');

/* Trigger structure for table `dav_cabecalho` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `HashDavCabecalho` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'root'@'localhost' */ /*!50003 TRIGGER `HashDavCabecalho` BEFORE UPDATE ON `dav_cabecalho` FOR EACH ROW BEGIN
	SET NEW.HASH_INCREMENTO = NEW.HASH_INCREMENTO + 1;
    END */$$


DELIMITER ;

/* Trigger structure for table `dav_detalhe` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `HashDavDetalhe` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'root'@'localhost' */ /*!50003 TRIGGER `HashDavDetalhe` BEFORE UPDATE ON `dav_detalhe` FOR EACH ROW BEGIN
	SET NEW.HASH_INCREMENTO = NEW.HASH_INCREMENTO + 1;
    END */$$


DELIMITER ;

/* Trigger structure for table `ecf_estoque` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `HashEstoque` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'root'@'localhost' */ /*!50003 TRIGGER `HashEstoque` BEFORE UPDATE ON `ecf_estoque` FOR EACH ROW BEGIN
	SET NEW.HASH_INCREMENTO = NEW.HASH_INCREMENTO + 1;
    END */$$


DELIMITER ;

/* Trigger structure for table `ecf_total_tipo_pgto` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `HashTotalTipoPgto` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'root'@'localhost' */ /*!50003 TRIGGER `HashTotalTipoPgto` BEFORE UPDATE ON `ecf_total_tipo_pgto` FOR EACH ROW BEGIN
	SET NEW.HASH_INCREMENTO = NEW.HASH_INCREMENTO + 1;
    END */$$


DELIMITER ;

/* Trigger structure for table `ecf_venda_cabecalho` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `HashVendaCabecalho` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'root'@'localhost' */ /*!50003 TRIGGER `HashVendaCabecalho` BEFORE UPDATE ON `ecf_venda_cabecalho` FOR EACH ROW BEGIN
	SET NEW.HASH_INCREMENTO = NEW.HASH_INCREMENTO + 1;
    END */$$


DELIMITER ;

/* Trigger structure for table `ecf_venda_detalhe` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `HashVendaDetalhe` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'root'@'localhost' */ /*!50003 TRIGGER `HashVendaDetalhe` BEFORE UPDATE ON `ecf_venda_detalhe` FOR EACH ROW BEGIN
	SET NEW.HASH_INCREMENTO = NEW.HASH_INCREMENTO + 1;
    END */$$


DELIMITER ;

/* Trigger structure for table `produto` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `HashProduto` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'root'@'localhost' */ /*!50003 TRIGGER `HashProduto` BEFORE UPDATE ON `produto` FOR EACH ROW BEGIN
	SET NEW.HASH_INCREMENTO = NEW.HASH_INCREMENTO + 1;
    END */$$


DELIMITER ;

/* Trigger structure for table `r01` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `HashR01` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'root'@'localhost' */ /*!50003 TRIGGER `HashR01` BEFORE UPDATE ON `r01` FOR EACH ROW BEGIN
	SET NEW.HASH_INCREMENTO = NEW.HASH_INCREMENTO + 1;
    END */$$


DELIMITER ;

/* Trigger structure for table `r02` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `HashR02` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'root'@'localhost' */ /*!50003 TRIGGER `HashR02` BEFORE UPDATE ON `r02` FOR EACH ROW BEGIN
	SET NEW.HASH_INCREMENTO = NEW.HASH_INCREMENTO + 1;
    END */$$


DELIMITER ;

/* Trigger structure for table `r03` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `HashR03` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'root'@'localhost' */ /*!50003 TRIGGER `HashR03` BEFORE UPDATE ON `r03` FOR EACH ROW BEGIN
	SET NEW.HASH_INCREMENTO = NEW.HASH_INCREMENTO + 1;
    END */$$


DELIMITER ;

/* Trigger structure for table `r06` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `HashR06` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'root'@'localhost' */ /*!50003 TRIGGER `HashR06` BEFORE UPDATE ON `r06` FOR EACH ROW BEGIN
	SET NEW.HASH_INCREMENTO = NEW.HASH_INCREMENTO + 1;
    END */$$


DELIMITER ;

/*Table structure for table `view_60d` */

DROP TABLE IF EXISTS `view_60d`;

/*!50001 DROP VIEW IF EXISTS `view_60d` */;
/*!50001 DROP TABLE IF EXISTS `view_60d` */;

/*!50001 CREATE TABLE  `view_60d`(
 `GTIN` varchar(14) ,
 `SERIE` varchar(20) ,
 `DATA_EMISSAO` date ,
 `ID` int(10) unsigned ,
 `ECF_ICMS_ST` varchar(4) ,
 `SOMA_QUANTIDADE` decimal(42,6) ,
 `SOMA_ITEM` decimal(42,6) ,
 `SOMA_BASE_ICMS` decimal(42,6) ,
 `SOMA_ICMS` decimal(42,6) 
)*/;

/*Table structure for table `view_60r` */

DROP TABLE IF EXISTS `view_60r`;

/*!50001 DROP VIEW IF EXISTS `view_60r` */;
/*!50001 DROP TABLE IF EXISTS `view_60r` */;

/*!50001 CREATE TABLE  `view_60r`(
 `GTIN` varchar(14) ,
 `SERIE` varchar(20) ,
 `DATA_EMISSAO` date ,
 `MES_EMISSAO` int(2) ,
 `ANO_EMISSAO` int(4) ,
 `ID` int(10) unsigned ,
 `ECF_ICMS_ST` varchar(4) ,
 `SOMA_QUANTIDADE` decimal(42,6) ,
 `SOMA_ITEM` decimal(42,6) ,
 `SOMA_BASE_ICMS` decimal(42,6) ,
 `SOMA_ICMS` decimal(42,6) 
)*/;

/*Table structure for table `view_61r` */

DROP TABLE IF EXISTS `view_61r`;

/*!50001 DROP VIEW IF EXISTS `view_61r` */;
/*!50001 DROP TABLE IF EXISTS `view_61r` */;

/*!50001 CREATE TABLE  `view_61r`(
 `GTIN` varchar(14) ,
 `DATA_EMISSAO` date ,
 `MES_EMISSAO` int(2) ,
 `ANO_EMISSAO` int(4) ,
 `ECF_ICMS_ST` varchar(4) ,
 `SOMA_QUANTIDADE` decimal(42,6) ,
 `SOMA_ITEM` decimal(42,6) ,
 `SOMA_BASE_ICMS` decimal(42,6) 
)*/;

/*Table structure for table `view_r04` */

DROP TABLE IF EXISTS `view_r04`;

/*!50001 DROP VIEW IF EXISTS `view_r04` */;
/*!50001 DROP TABLE IF EXISTS `view_r04` */;

/*!50001 CREATE TABLE  `view_r04`(
 `VCID` int(10) unsigned ,
 `ID_ECF_MOVIMENTO` int(10) unsigned ,
 `SERIE_ECF` varchar(20) ,
 `CCF` int(10) unsigned ,
 `COO` int(10) unsigned ,
 `DATA_VENDA` date ,
 `VALOR_VENDA` decimal(20,6) ,
 `HASH_TRIPA` varchar(32) ,
 `HASH_INCREMENTO` int(11) ,
 `DESCONTO` decimal(20,6) ,
 `ACRESCIMO` decimal(20,6) ,
 `VALOR_FINAL` decimal(20,6) ,
 `STATUS_VENDA` char(1) ,
 `CUPOM_CANCELADO` char(1) ,
 `NOME_CLIENTE` varchar(100) ,
 `PIS` decimal(20,6) ,
 `COFINS` decimal(20,6) ,
 `CPF_CNPJ_CLIENTE` varchar(14) ,
 `MID` int(10) unsigned ,
 `ID_ECF_IMPRESSORA` int(10) unsigned ,
 `ID_ECF_OPERADOR` int(10) unsigned 
)*/;

/*Table structure for table `view_r05` */

DROP TABLE IF EXISTS `view_r05`;

/*!50001 DROP VIEW IF EXISTS `view_r05` */;
/*!50001 DROP TABLE IF EXISTS `view_r05` */;

/*!50001 CREATE TABLE  `view_r05`(
 `VCID` int(10) unsigned ,
 `VID` int(10) unsigned ,
 `ITEM` int(10) unsigned ,
 `SERIE_ECF` varchar(20) ,
 `GTIN` varchar(14) ,
 `CCF` int(10) unsigned ,
 `COO` int(10) unsigned ,
 `DESCRICAO_PDV` varchar(30) ,
 `QUANTIDADE` decimal(20,6) ,
 `CST` char(3) ,
 `PIS` decimal(20,6) ,
 `COFINS` decimal(20,6) ,
 `HASH_TRIPA` varchar(32) ,
 `HASH_INCREMENTO` int(11) ,
 `SIGLA_UNIDADE` varchar(10) ,
 `VALOR_UNITARIO` decimal(20,6) ,
 `DESCONTO` decimal(20,6) ,
 `ACRESCIMO` decimal(20,6) ,
 `CFOP` int(10) unsigned ,
 `TAXA_ICMS` decimal(20,6) ,
 `ID_ECF_PRODUTO` int(10) unsigned ,
 `TOTAL_ITEM` decimal(20,6) ,
 `TOTALIZADOR_PARCIAL` varchar(10) ,
 `CANCELADO` char(1) ,
 `IAT` char(1) ,
 `IPPT` char(1) ,
 `ID_UNIDADE` int(10) unsigned 
)*/;

/*View structure for view view_60d */

/*!50001 DROP TABLE IF EXISTS `view_60d` */;
/*!50001 DROP VIEW IF EXISTS `view_60d` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `view_60d` AS (select `vd`.`GTIN` AS `GTIN`,`i`.`SERIE` AS `SERIE`,`vc`.`DATA_VENDA` AS `DATA_EMISSAO`,`m`.`ID` AS `ID`,`vd`.`ECF_ICMS_ST` AS `ECF_ICMS_ST`,sum(`vd`.`QUANTIDADE`) AS `SOMA_QUANTIDADE`,sum(`vd`.`VALOR_TOTAL`) AS `SOMA_ITEM`,sum(`vd`.`BASE_ICMS`) AS `SOMA_BASE_ICMS`,sum(`vd`.`ICMS`) AS `SOMA_ICMS` from (((`ecf_venda_cabecalho` `vc` join `ecf_venda_detalhe` `vd`) join `ecf_impressora` `i`) join `ecf_movimento` `m`) where ((`vc`.`ID_ECF_MOVIMENTO` = `m`.`ID`) and (`m`.`ID_ECF_IMPRESSORA` = `i`.`ID`) and (`vd`.`ID_ECF_VENDA_CABECALHO` = `vc`.`ID`) and (`vd`.`CANCELADO` = 'N')) group by `vd`.`GTIN`,`i`.`SERIE`,`vc`.`DATA_VENDA`,`m`.`ID`,`vd`.`ECF_ICMS_ST`) */;

/*View structure for view view_60r */

/*!50001 DROP TABLE IF EXISTS `view_60r` */;
/*!50001 DROP VIEW IF EXISTS `view_60r` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `view_60r` AS (select `vd`.`GTIN` AS `GTIN`,`i`.`SERIE` AS `SERIE`,`vc`.`DATA_VENDA` AS `DATA_EMISSAO`,month(`vc`.`DATA_VENDA`) AS `MES_EMISSAO`,year(`vc`.`DATA_VENDA`) AS `ANO_EMISSAO`,`m`.`ID` AS `ID`,`vd`.`ECF_ICMS_ST` AS `ECF_ICMS_ST`,sum(`vd`.`QUANTIDADE`) AS `SOMA_QUANTIDADE`,sum(`vd`.`VALOR_TOTAL`) AS `SOMA_ITEM`,sum(`vd`.`BASE_ICMS`) AS `SOMA_BASE_ICMS`,sum(`vd`.`ICMS`) AS `SOMA_ICMS` from (((`ecf_venda_cabecalho` `vc` join `ecf_venda_detalhe` `vd`) join `ecf_impressora` `i`) join `ecf_movimento` `m`) where ((`vc`.`ID_ECF_MOVIMENTO` = `m`.`ID`) and (`m`.`ID_ECF_IMPRESSORA` = `i`.`ID`) and (`vd`.`ID_ECF_VENDA_CABECALHO` = `vc`.`ID`)) group by month(`vc`.`DATA_VENDA`),year(`vc`.`DATA_VENDA`),`vd`.`GTIN`) */;

/*View structure for view view_61r */

/*!50001 DROP TABLE IF EXISTS `view_61r` */;
/*!50001 DROP VIEW IF EXISTS `view_61r` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `view_61r` AS (select `p`.`GTIN` AS `GTIN`,`nf2c`.`DATA_EMISSAO` AS `DATA_EMISSAO`,month(`nf2c`.`DATA_EMISSAO`) AS `MES_EMISSAO`,year(`nf2c`.`DATA_EMISSAO`) AS `ANO_EMISSAO`,`nf2d`.`ECF_ICMS_ST` AS `ECF_ICMS_ST`,sum(`nf2d`.`QUANTIDADE`) AS `SOMA_QUANTIDADE`,sum(`nf2d`.`VALOR_TOTAL`) AS `SOMA_ITEM`,sum(`nf2d`.`BASE_ICMS`) AS `SOMA_BASE_ICMS` from ((`nota_fiscal_cabecalho` `nf2c` join `nota_fiscal_detalhe` `nf2d`) join `produto` `p`) where ((`nf2d`.`ID_PRODUTO` = `p`.`ID`) and (`nf2d`.`ID_NF_CABECALHO` = `nf2c`.`ID`)) group by month(`nf2c`.`DATA_EMISSAO`),year(`nf2c`.`DATA_EMISSAO`),`p`.`GTIN`,`p`.`ECF_ICMS_ST`) */;

/*View structure for view view_r04 */

/*!50001 DROP TABLE IF EXISTS `view_r04` */;
/*!50001 DROP VIEW IF EXISTS `view_r04` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `view_r04` AS (select `vc`.`ID` AS `VCID`,`vc`.`ID_ECF_MOVIMENTO` AS `ID_ECF_MOVIMENTO`,`vc`.`SERIE_ECF` AS `SERIE_ECF`,`vc`.`CCF` AS `CCF`,`vc`.`COO` AS `COO`,`vc`.`DATA_VENDA` AS `DATA_VENDA`,`vc`.`VALOR_VENDA` AS `VALOR_VENDA`,`vc`.`HASH_TRIPA` AS `HASH_TRIPA`,`vc`.`HASH_INCREMENTO` AS `HASH_INCREMENTO`,`vc`.`DESCONTO` AS `DESCONTO`,`vc`.`ACRESCIMO` AS `ACRESCIMO`,`vc`.`VALOR_FINAL` AS `VALOR_FINAL`,`vc`.`STATUS_VENDA` AS `STATUS_VENDA`,`vc`.`CUPOM_CANCELADO` AS `CUPOM_CANCELADO`,`vc`.`NOME_CLIENTE` AS `NOME_CLIENTE`,`vc`.`PIS` AS `PIS`,`vc`.`COFINS` AS `COFINS`,`vc`.`CPF_CNPJ_CLIENTE` AS `CPF_CNPJ_CLIENTE`,`m`.`ID` AS `MID`,`m`.`ID_ECF_IMPRESSORA` AS `ID_ECF_IMPRESSORA`,`m`.`ID_ECF_OPERADOR` AS `ID_ECF_OPERADOR` from (`ecf_venda_cabecalho` `vc` join `ecf_movimento` `m`) where (`vc`.`ID_ECF_MOVIMENTO` = `m`.`ID`)) */;

/*View structure for view view_r05 */

/*!50001 DROP TABLE IF EXISTS `view_r05` */;
/*!50001 DROP VIEW IF EXISTS `view_r05` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `view_r05` AS (select `vc`.`ID` AS `VCID`,`v`.`ID` AS `VID`,`v`.`ITEM` AS `ITEM`,`v`.`SERIE_ECF` AS `SERIE_ECF`,`v`.`GTIN` AS `GTIN`,`v`.`CCF` AS `CCF`,`v`.`COO` AS `COO`,`p`.`DESCRICAO_PDV` AS `DESCRICAO_PDV`,`v`.`QUANTIDADE` AS `QUANTIDADE`,`v`.`CST` AS `CST`,`v`.`PIS` AS `PIS`,`v`.`COFINS` AS `COFINS`,`v`.`HASH_TRIPA` AS `HASH_TRIPA`,`v`.`HASH_INCREMENTO` AS `HASH_INCREMENTO`,`u`.`NOME` AS `SIGLA_UNIDADE`,`v`.`VALOR_UNITARIO` AS `VALOR_UNITARIO`,`v`.`DESCONTO` AS `DESCONTO`,`v`.`ACRESCIMO` AS `ACRESCIMO`,`v`.`CFOP` AS `CFOP`,`v`.`TAXA_ICMS` AS `TAXA_ICMS`,`v`.`ID_ECF_PRODUTO` AS `ID_ECF_PRODUTO`,`v`.`TOTAL_ITEM` AS `TOTAL_ITEM`,`v`.`TOTALIZADOR_PARCIAL` AS `TOTALIZADOR_PARCIAL`,`v`.`CANCELADO` AS `CANCELADO`,`p`.`IAT` AS `IAT`,`p`.`IPPT` AS `IPPT`,`p`.`ID_UNIDADE_PRODUTO` AS `ID_UNIDADE` from (((`ecf_venda_cabecalho` `vc` join `ecf_venda_detalhe` `v`) join `produto` `p`) join `unidade_produto` `u`) where ((`vc`.`ID` = `v`.`ID_ECF_VENDA_CABECALHO`) and (`v`.`ID_ECF_PRODUTO` = `p`.`ID`) and (`p`.`ID_UNIDADE_PRODUTO` = `u`.`ID`))) */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
