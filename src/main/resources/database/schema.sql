
CREATE TABLE `article_tbl` (
  `ID` int(11) NOT NULL,
  `MODEL` varchar(20) DEFAULT NULL,
  `GB` smallint(4) DEFAULT NULL,
  `GRADE_SUP` varchar(2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Struttura della tabella `battery_tbl`
--

CREATE TABLE `battery_tbl` (
  `ID` int(11) NOT NULL,
  `IMEI` varchar(15) DEFAULT NULL,
  `SOH` smallint(3) DEFAULT NULL,
  `CYCLES` smallint(3) DEFAULT NULL,
  `REPLACE` tinyint(1) DEFAULT NULL,
  `DATE` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- --------------------------------------------------------

--
-- Struttura della tabella `cart_tbl`
--

CREATE TABLE `cart_tbl` (
  `ID` int(11) NOT NULL,
  `ID_ARTICLE` int(11) DEFAULT NULL,
  `QTY` smallint(6) DEFAULT NULL,
  `ID_SUPPLIER` int(11) DEFAULT NULL,
  `PRICE` double DEFAULT NULL,
  `IVA` tinyint(3) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- --------------------------------------------------------

--
-- Struttura della tabella `chests_tbl`
--

CREATE TABLE `chests_tbl` (
  `ID` int(11) NOT NULL,
  `NUMBER` int(11) NOT NULL,
  `IMEI` varchar(15) NOT NULL,
  `PHASE` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- --------------------------------------------------------

--
-- Struttura della tabella `comments_tbl`
--

CREATE TABLE `comments_tbl` (
  `ID` int(11) NOT NULL,
  `IMEI` varchar(15) DEFAULT NULL,
  `STATUS` varchar(7) DEFAULT NULL,
  `ID_ISSUE` varchar(5) DEFAULT NULL,
  `COMMENT` varchar(255) DEFAULT NULL,
  `DATE` datetime DEFAULT NULL,
  `OPERATOR` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- --------------------------------------------------------

--
-- Struttura della tabella `component_tbl`
--

CREATE TABLE `component_tbl` (
  `ID` int(11) NOT NULL,
  `QTY` int(11) NOT NULL,
  `SKU` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Struttura della tabella `files_tbl`
--

CREATE TABLE `files_tbl` (
  `ID` int(11) NOT NULL,
  `ORDER_NUMBER` int(11) NOT NULL,
  `NAME` varchar(50) DEFAULT NULL,
  `TYPE` varchar(25) DEFAULT NULL,
  `DATA` mediumblob DEFAULT NULL,
  `FORMAT` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- --------------------------------------------------------

--
-- Struttura della tabella `grade_tbl`
--

CREATE TABLE `grade_tbl` (
  `IMEI` varchar(15) DEFAULT NULL,
  `GRADE_SUP` varchar(2) DEFAULT NULL,
  `GRADE_CHECK` varchar(2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Struttura della tabella `ios_tbl`
--

CREATE TABLE `ios_tbl` (
  `version` decimal(3,1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Struttura della tabella `issues_tbl`
--

CREATE TABLE `issues_tbl` (
  `ID` int(11) NOT NULL,
  `IMEI` varchar(15) DEFAULT NULL,
  `DATA` datetime DEFAULT NULL,
  `OPERATOR` varchar(25) DEFAULT NULL,
  `ID_ISSUE` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Struttura della tabella `issue_list_tbl`
--

CREATE TABLE `issue_list_tbl` (
  `ID` int(11) NOT NULL,
  `TL` varchar(5) DEFAULT NULL,
  `LABEL` varchar(50) DEFAULT NULL,
  `DEPARTMENT` varchar(8) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;


--
-- Struttura stand-in per le viste `last_status_view`
-- (Vedi sotto per la vista effettiva)
--
CREATE TABLE `last_status_view` (
`ID` int(11)
,`OPERATOR` varchar(25)
,`ACTUAL_STATUS` varchar(7)
,`SEND_TO` varchar(7)
,`DATE` datetime
,`IMEI` varchar(15)
,`TIMER` time
);


--
-- Struttura della tabella `order_tbl`
--

CREATE TABLE `order_tbl` (
  `ID` int(11) NOT NULL,
  `ID_ARTICLE` int(11) DEFAULT NULL,
  `QTY` smallint(6) DEFAULT NULL,
  `INIT_QTY` int(6) DEFAULT NULL,
  `ID_SUPPLIER` int(11) DEFAULT NULL,
  `PRICE` double DEFAULT NULL,
  `IVA` tinyint(3) DEFAULT NULL,
  `DATE` date DEFAULT NULL,
  `DATE_PURCHASE` date DEFAULT NULL,
  `NUMBER_ORDER` int(11) DEFAULT NULL,
  `COURIER` varchar(10) DEFAULT 'select',
  `TRACKING` varchar(100) DEFAULT 'insert',
  `SUP_ORDER_NUMBER` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Struttura della tabella `pay_tbl`
--

CREATE TABLE `pay_tbl` (
  `NUMBER_ORDER` int(11) NOT NULL,
  `PAYMENT_OPTIONS` varchar(20) DEFAULT NULL,
  `PAID` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Struttura della tabella `phases_tbl`
--

CREATE TABLE `phases_tbl` (
  `PHASE` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;


--
-- Struttura della tabella `phone_tbl`
--

CREATE TABLE `phone_tbl` (
  `ID_ARTICLE` int(11) DEFAULT NULL,
  `ID_SUPPLIER` int(11) DEFAULT NULL,
  `ORDER_NUMBER` int(11) DEFAULT NULL,
  `IMEI` varchar(15) NOT NULL,
  `MODEL` varchar(20) DEFAULT NULL,
  `GB` smallint(4) DEFAULT NULL,
  `COLOR` varchar(15) DEFAULT NULL,
  `SKU` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;
-- --------------------------------------------------------

--
-- Struttura della tabella `planning_preview_tbl`
--

CREATE TABLE `planning_preview_tbl` (
  `ID` int(11) NOT NULL,
  `DATE` datetime DEFAULT NULL,
  `SKU` varchar(15) DEFAULT NULL,
  `QTY` smallint(6) DEFAULT NULL,
  `STATUS` varchar(7) DEFAULT NULL,
  `OPERATOR` varchar(25) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- --------------------------------------------------------

--
-- Struttura della tabella `planning_tbl`
--

CREATE TABLE `planning_tbl` (
  `ID` int(11) NOT NULL,
  `DATE` datetime DEFAULT NULL,
  `SKU` varchar(15) DEFAULT NULL,
  `QTY` smallint(6) DEFAULT NULL,
  `STATUS` varchar(7) DEFAULT NULL,
  `OPERATOR` varchar(25) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- --------------------------------------------------------

--
-- Struttura della tabella `reparations_tbl`
--

CREATE TABLE `reparations_tbl` (
  `ID` int(11) NOT NULL,
  `IMEI` varchar(15) DEFAULT NULL,
  `DATE` datetime DEFAULT NULL,
  `OPERATOR` varchar(25) DEFAULT NULL,
  `TL` varchar(5) DEFAULT NULL,
  `COMPONENT` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Struttura della tabella `report_tbl`
--

CREATE TABLE `report_tbl` (
  `ID` int(11) NOT NULL,
  `DATE` datetime DEFAULT NULL,
  `REPORTER` varchar(25) DEFAULT NULL,
  `ISSUE` varchar(5) DEFAULT NULL,
  `OPERATOR` varchar(25) DEFAULT NULL,
  `IMEI` varchar(15) DEFAULT NULL,
  `PHASE` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Struttura della tabella `shipping_tbl`
--

CREATE TABLE `shipping_tbl` (
  `ID` int(11) NOT NULL,
  `ORDER_NUMBER` int(10) NOT NULL,
  `TRACKING` varchar(25) NOT NULL,
  `COURIER` varchar(10) NOT NULL,
  `DATE` date NOT NULL,
  `MARKET` varchar(15) NOT NULL,
  `OPERATOR` varchar(20) NOT NULL,
  `PRICE` double(6,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Struttura della tabella `status_tbl`
--

CREATE TABLE `status_tbl` (
  `ID` int(11) NOT NULL,
  `IMEI` varchar(15) DEFAULT NULL,
  `DATE` datetime DEFAULT NULL,
  `ACTUAL_STATUS` varchar(7) DEFAULT NULL,
  `SEND_TO` varchar(7) DEFAULT NULL,
  `OPERATOR` varchar(25) DEFAULT NULL,
  `TIMER` time DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Struttura della tabella `suppliers_tbl`
--

CREATE TABLE `suppliers_tbl` (
  `ID` int(11) NOT NULL,
  `SUPPLIER` varchar(20) DEFAULT NULL,
  `PROD_NAME` varchar(15) DEFAULT NULL,
  `ADDRESS` varchar(50) DEFAULT NULL,
  `MAIL` varchar(25) DEFAULT NULL,
  `PHONE` varchar(20) DEFAULT NULL,
  `RMA` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Struttura della tabella `testing_tbl`
--

CREATE TABLE `testing_tbl` (
  `ID` int(11) NOT NULL,
  `IMEI` varchar(15) NOT NULL,
  `DATE` datetime NOT NULL,
  `OPERATOR` varchar(25) DEFAULT NULL,
  `iOS` varchar(255) DEFAULT NULL,
  `TL0` tinyint(1) NOT NULL,
  `TL1` tinyint(1) NOT NULL DEFAULT 1,
  `TL4` tinyint(1) NOT NULL DEFAULT 1,
  `TL5` tinyint(1) NOT NULL DEFAULT 1,
  `TL5A` tinyint(1) NOT NULL DEFAULT 1,
  `TL5B` tinyint(1) NOT NULL,
  `TL8` tinyint(1) NOT NULL DEFAULT 1,
  `TL8P` tinyint(1) NOT NULL DEFAULT 1,
  `TL9` tinyint(1) NOT NULL DEFAULT 1,
  `TL9T` tinyint(1) NOT NULL DEFAULT 1,
  `TL10` tinyint(1) NOT NULL DEFAULT 1,
  `TL10G` tinyint(1) NOT NULL DEFAULT 1,
  `TL10T` tinyint(1) NOT NULL DEFAULT 1,
  `TL11G` tinyint(1) NOT NULL DEFAULT 1,
  `TL11` tinyint(1) NOT NULL DEFAULT 1,
  `TL12` tinyint(1) NOT NULL DEFAULT 1,
  `TL13` tinyint(1) NOT NULL DEFAULT 1,
  `TL14` tinyint(1) NOT NULL DEFAULT 1,
  `TL14P` tinyint(1) NOT NULL DEFAULT 1,
  `TL14A` tinyint(1) NOT NULL DEFAULT 1,
  `TL14B` tinyint(1) NOT NULL,
  `TL14T` tinyint(1) NOT NULL DEFAULT 1,
  `TL16` tinyint(1) NOT NULL DEFAULT 1,
  `TL15` tinyint(1) NOT NULL DEFAULT 1,
  `TL17` tinyint(1) NOT NULL DEFAULT 1,
  `TL18` tinyint(1) NOT NULL DEFAULT 1,
  `TL19` tinyint(1) NOT NULL DEFAULT 1,
  `TL19A` tinyint(1) NOT NULL DEFAULT 1,
  `TL21` tinyint(1) NOT NULL DEFAULT 1,
  `TL22` tinyint(1) NOT NULL DEFAULT 1,
  `TL22T` tinyint(1) NOT NULL DEFAULT 1,
  `TL24` tinyint(1) NOT NULL DEFAULT 1,
  `TL26` tinyint(1) NOT NULL DEFAULT 1,
  `TL26T` tinyint(1) NOT NULL DEFAULT 1,
  `TL27` tinyint(1) NOT NULL DEFAULT 1,
  `TL27T` tinyint(1) NOT NULL DEFAULT 1,
  `TL28` tinyint(1) NOT NULL DEFAULT 1,
  `TL28T` tinyint(1) NOT NULL DEFAULT 1,
  `TL29` tinyint(1) NOT NULL DEFAULT 1,
  `TL29A` tinyint(1) NOT NULL DEFAULT 1,
  `TL29B` tinyint(1) NOT NULL DEFAULT 1,
  `TL29C` tinyint(1) NOT NULL DEFAULT 1,
  `TL30` tinyint(1) NOT NULL DEFAULT 1,
  `TL32` tinyint(1) NOT NULL DEFAULT 1,
  `TL36` tinyint(1) NOT NULL DEFAULT 1,
  `TL36T` tinyint(1) NOT NULL DEFAULT 1,
  `TL37` tinyint(1) NOT NULL DEFAULT 1,
  `TL38` tinyint(1) NOT NULL DEFAULT 1,
  `TL39` tinyint(1) NOT NULL DEFAULT 1,
  `TL40` tinyint(1) NOT NULL DEFAULT 1,
  `TL41` tinyint(1) NOT NULL DEFAULT 1,
  `TL42` tinyint(1) NOT NULL DEFAULT 1,
  `TL42A` tinyint(1) NOT NULL DEFAULT 1,
  `TL2` tinyint(1) NOT NULL,
  `TL2T` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Struttura della tabella `users_tbl`
--

CREATE TABLE `users_tbl` (
  `USERNAME` varchar(25) NOT NULL,
  `PASSWORD` varchar(70) DEFAULT NULL,
  `ROLES` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Struttura per vista `last_status_view`
--
DROP TABLE IF EXISTS `last_status_view`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `last_status_view`  AS SELECT `s`.`ID` AS `ID`, `s`.`OPERATOR` AS `OPERATOR`, `s`.`ACTUAL_STATUS` AS `ACTUAL_STATUS`, `s`.`SEND_TO` AS `SEND_TO`, `s`.`DATE` AS `DATE`, `s`.`IMEI` AS `IMEI`, `s`.`TIMER` AS `TIMER` FROM `status_tbl` AS `s` WHERE `s`.`DATE` in (select max(`s2`.`DATE`) from `status_tbl` `s2` where `s`.`IMEI` = `s2`.`IMEI`) AND `s`.`DATE` > '2023-06-01 00:00:00' GROUP BY `s`.`IMEI` ORDER BY `s`.`DATE` DESC ;

-- --------------------------------------------------------

--
-- Struttura per vista `status_view`
--
DROP TABLE IF EXISTS `status_view`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `status_view`  AS SELECT `s`.`OPERATOR` AS `OPERATOR`, `s`.`ACTUAL_STATUS` AS `ACTUAL_STATUS`, `s`.`SEND_TO` AS `SEND_TO`, `s`.`DATE` AS `DATE`, `s`.`IMEI` AS `IMEI` FROM `status_tbl` AS `s` WHERE `s`.`DATE` in (select max(`s2`.`DATE`) from `status_tbl` `s2` where `s`.`IMEI` = `s2`.`IMEI`) GROUP BY `s`.`IMEI` ORDER BY `s`.`DATE` ASC ;

--
-- Indici per le tabelle scaricate
--

--
-- Indici per le tabelle `article_tbl`
--
ALTER TABLE `article_tbl`
  ADD PRIMARY KEY (`ID`);

--
-- Indici per le tabelle `battery_tbl`
--
ALTER TABLE `battery_tbl`
  ADD PRIMARY KEY (`ID`);

--
-- Indici per le tabelle `cart_tbl`
--
ALTER TABLE `cart_tbl`
  ADD PRIMARY KEY (`ID`);

--
-- Indici per le tabelle `chests_tbl`
--
ALTER TABLE `chests_tbl`
  ADD PRIMARY KEY (`ID`);

--
-- Indici per le tabelle `comments_tbl`
--
ALTER TABLE `comments_tbl`
  ADD PRIMARY KEY (`ID`);

--
-- Indici per le tabelle `component_tbl`
--
ALTER TABLE `component_tbl`
  ADD PRIMARY KEY (`ID`);

--
-- Indici per le tabelle `files_tbl`
--
ALTER TABLE `files_tbl`
  ADD PRIMARY KEY (`ID`);

--
-- Indici per le tabelle `issues_tbl`
--
ALTER TABLE `issues_tbl`
  ADD PRIMARY KEY (`ID`);

--
-- Indici per le tabelle `issue_list_tbl`
--
ALTER TABLE `issue_list_tbl`
  ADD PRIMARY KEY (`ID`);

--
-- Indici per le tabelle `order_tbl`
--
ALTER TABLE `order_tbl`
  ADD PRIMARY KEY (`ID`);

--
-- Indici per le tabelle `pay_tbl`
--
ALTER TABLE `pay_tbl`
  ADD PRIMARY KEY (`NUMBER_ORDER`);

--
-- Indici per le tabelle `phone_tbl`
--
ALTER TABLE `phone_tbl`
  ADD PRIMARY KEY (`IMEI`);

--
-- Indici per le tabelle `planning_preview_tbl`
--
ALTER TABLE `planning_preview_tbl`
  ADD PRIMARY KEY (`ID`);

--
-- Indici per le tabelle `planning_tbl`
--
ALTER TABLE `planning_tbl`
  ADD PRIMARY KEY (`ID`);

--
-- Indici per le tabelle `reparations_tbl`
--
ALTER TABLE `reparations_tbl`
  ADD PRIMARY KEY (`ID`);

--
-- Indici per le tabelle `report_tbl`
--
ALTER TABLE `report_tbl`
  ADD PRIMARY KEY (`ID`);

--
-- Indici per le tabelle `shipping_tbl`
--
ALTER TABLE `shipping_tbl`
  ADD PRIMARY KEY (`ID`);

--
-- Indici per le tabelle `status_tbl`
--
ALTER TABLE `status_tbl`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `idx_imei` (`IMEI`);

--
-- Indici per le tabelle `suppliers_tbl`
--
ALTER TABLE `suppliers_tbl`
  ADD PRIMARY KEY (`ID`);

--
-- Indici per le tabelle `testing_tbl`
--
ALTER TABLE `testing_tbl`
  ADD PRIMARY KEY (`ID`);

--
-- Indici per le tabelle `users_tbl`
--
ALTER TABLE `users_tbl`
  ADD PRIMARY KEY (`USERNAME`);

--
-- AUTO_INCREMENT per le tabelle scaricate
--

--
-- AUTO_INCREMENT per la tabella `article_tbl`
--
ALTER TABLE `article_tbl`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=108;

--
-- AUTO_INCREMENT per la tabella `battery_tbl`
--
ALTER TABLE `battery_tbl`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8993;

--
-- AUTO_INCREMENT per la tabella `cart_tbl`
--
ALTER TABLE `cart_tbl`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT per la tabella `chests_tbl`
--
ALTER TABLE `chests_tbl`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=883;

--
-- AUTO_INCREMENT per la tabella `comments_tbl`
--
ALTER TABLE `comments_tbl`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=152;

--
-- AUTO_INCREMENT per la tabella `component_tbl`
--
ALTER TABLE `component_tbl`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=46;

--
-- AUTO_INCREMENT per la tabella `files_tbl`
--
ALTER TABLE `files_tbl`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT per la tabella `issues_tbl`
--
ALTER TABLE `issues_tbl`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT per la tabella `issue_list_tbl`
--
ALTER TABLE `issue_list_tbl`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=56;

--
-- AUTO_INCREMENT per la tabella `order_tbl`
--
ALTER TABLE `order_tbl`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=496;

--
-- AUTO_INCREMENT per la tabella `planning_preview_tbl`
--
ALTER TABLE `planning_preview_tbl`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT per la tabella `planning_tbl`
--
ALTER TABLE `planning_tbl`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT per la tabella `reparations_tbl`
--
ALTER TABLE `reparations_tbl`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3313;

--
-- AUTO_INCREMENT per la tabella `report_tbl`
--
ALTER TABLE `report_tbl`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=566;

--
-- AUTO_INCREMENT per la tabella `shipping_tbl`
--
ALTER TABLE `shipping_tbl`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT per la tabella `status_tbl`
--
ALTER TABLE `status_tbl`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17822;

--
-- AUTO_INCREMENT per la tabella `suppliers_tbl`
--
ALTER TABLE `suppliers_tbl`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT per la tabella `testing_tbl`
--
ALTER TABLE `testing_tbl`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10297;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;