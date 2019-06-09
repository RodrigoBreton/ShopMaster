/* Direcciones de Tiendas */
INSERT INTO `shopmaster`.`direccion` (`id`, `calle`, `portal`, `piso`, `codigo_postal`, `ciudad`) VALUES ('1', 'Monasterio de Caveiro', '12', 'Bajo C', '15010', 'A Coruña');
INSERT INTO `shopmaster`.`direccion` (`id`, `calle`, `portal`, `piso`, `codigo_postal`, `ciudad`) VALUES ('2', 'C/Barcelona', '64', '1', '15010', 'A Coruña');
INSERT INTO `shopmaster`.`direccion` (`id`, `calle`, `portal`, `piso`, `codigo_postal`, `ciudad`) VALUES ('3', 'CC Marineda City', '-', '-', '15010', 'A Coruña');
INSERT INTO `shopmaster`.`direccion` (`id`, `calle`, `portal`, `piso`, `codigo_postal`, `ciudad`) VALUES ('4', 'CC Marineda City', '-', '-', '15010', 'A Coruña');
INSERT INTO `shopmaster`.`direccion` (`id`, `calle`, `portal`, `piso`, `codigo_postal`, `ciudad`) VALUES ('5', 'Calle Real', '125', '2', '15023', 'A Coruña');
INSERT INTO `shopmaster`.`direccion` (`id`, `calle`, `portal`, `piso`, `codigo_postal`, `ciudad`) VALUES ('6', 'Galileo Galilei', '32', 'bajo A', '15020', 'A Coruña');

/* Tiendas */
INSERT INTO `shopmaster`.`tienda` (`id`, `nombre`, `id_direccion`) VALUES ('1', 'Zara', '1');
INSERT INTO `shopmaster`.`tienda` (`id`, `nombre`, `id_direccion`) VALUES ('2', 'Calzado Luis', '2');
INSERT INTO `shopmaster`.`tienda` (`id`, `nombre`, `id_direccion`) VALUES ('3', 'Media Mark', '3');
INSERT INTO `shopmaster`.`tienda` (`id`, `nombre`, `id_direccion`) VALUES ('4', 'Foot Locker', '4');
INSERT INTO `shopmaster`.`tienda` (`id`, `nombre`, `id_direccion`) VALUES ('5', 'Pull&Bear', '5');
INSERT INTO `shopmaster`.`tienda` (`id`, `nombre`, `id_direccion`) VALUES ('6', 'Worten', '6');

/* Productos */
INSERT INTO `shopmaster`.`producto` (`id`, `nombre`, `precio`) VALUES ('1', 'TV Samsung', '1500 €');
INSERT INTO `shopmaster`.`producto` (`id`, `nombre`, `precio`) VALUES ('2', 'Tostadora', '19.99 €');
INSERT INTO `shopmaster`.`producto` (`id`, `nombre`, `precio`) VALUES ('3', 'PlayStatio', '299.99 €');
INSERT INTO `shopmaster`.`producto` (`id`, `nombre`, `precio`) VALUES ('4', 'XBOX ONE', '199.99 €');
INSERT INTO `shopmaster`.`producto` (`id`, `nombre`, `precio`) VALUES ('5', 'Nintendo Swich', '275 €');
INSERT INTO `shopmaster`.`producto` (`id`, `nombre`, `precio`) VALUES ('6', 'Microondas', '59.99 €');
INSERT INTO `shopmaster`.`producto` (`id`, `nombre`, `precio`) VALUES ('7', 'Lavadora', '349.99 €');
INSERT INTO `shopmaster`.`producto` (`id`, `nombre`, `precio`) VALUES ('8', 'Teclado Razer', '147.50€');
INSERT INTO `shopmaster`.`producto` (`id`, `nombre`, `precio`) VALUES ('9', 'Monitor OMEN', '250€');
INSERT INTO `shopmaster`.`producto` (`id`, `nombre`, `precio`) VALUES ('10', 'Iphone', '999.99€');

INSERT INTO `shopmaster`.`producto` (`id`, `nombre`, `precio`) VALUES ('11', 'AirMax', '140€');
INSERT INTO `shopmaster`.`producto` (`id`, `nombre`, `precio`) VALUES ('12', 'AirForce', '100€');
INSERT INTO `shopmaster`.`producto` (`id`, `nombre`, `precio`) VALUES ('13', 'Vans', '80€');
INSERT INTO `shopmaster`.`producto` (`id`, `nombre`, `precio`) VALUES ('14', 'Nike Tn', '180€');
INSERT INTO `shopmaster`.`producto` (`id`, `nombre`, `precio`) VALUES ('15', 'VapoMax', '210€');
INSERT INTO `shopmaster`.`producto` (`id`, `nombre`, `precio`) VALUES ('16', 'Reebook Classic', '99€');
INSERT INTO `shopmaster`.`producto` (`id`, `nombre`, `precio`) VALUES ('17', 'Jordan ', '110€');
INSERT INTO `shopmaster`.`producto` (`id`, `nombre`, `precio`) VALUES ('18', 'Sudadera Nike', '80€');
INSERT INTO `shopmaster`.`producto` (`id`, `nombre`, `precio`) VALUES ('19', 'Pantalon Jordan', '90€');
INSERT INTO `shopmaster`.`producto` (`id`, `nombre`, `precio`) VALUES ('20', 'Gorra Lakers', '50€');
INSERT INTO `shopmaster`.`producto` (`id`, `nombre`, `precio`) VALUES ('21', 'Chaqueta Nets', '180€');
INSERT INTO `shopmaster`.`producto` (`id`, `nombre`, `precio`) VALUES ('22', 'Calcetines Adidas ', '25€');
INSERT INTO `shopmaster`.`producto` (`id`, `nombre`, `precio`) VALUES ('23', 'Adidas Classics', '80€');
INSERT INTO `shopmaster`.`producto` (`id`, `nombre`, `precio`) VALUES ('24', 'Sudadera Adidas', '70€');
INSERT INTO `shopmaster`.`producto` (`id`, `nombre`, `precio`) VALUES ('25', 'Camiseta Jordan', '35€');

INSERT INTO `shopmaster`.`producto` (`id`, `nombre`, `precio`) VALUES ('26', 'Chaqueta Vaquera', '30€');
INSERT INTO `shopmaster`.`producto` (`id`, `nombre`, `precio`) VALUES ('27', 'Sudadera Capucha', '20€');
INSERT INTO `shopmaster`.`producto` (`id`, `nombre`, `precio`) VALUES ('28', 'Camisa', '15€');
INSERT INTO `shopmaster`.`producto` (`id`, `nombre`, `precio`) VALUES ('30', 'Camiseta sisa', '10€');
INSERT INTO `shopmaster`.`producto` (`id`, `nombre`, `precio`) VALUES ('31', 'Camiseta corta', '10€');
INSERT INTO `shopmaster`.`producto` (`id`, `nombre`, `precio`) VALUES ('32', 'Camiseta larga', '10€');
INSERT INTO `shopmaster`.`producto` (`id`, `nombre`, `precio`) VALUES ('33', 'Vestido ', '25€');
INSERT INTO `shopmaster`.`producto` (`id`, `nombre`, `precio`) VALUES ('34', 'Tacones', '35€');
INSERT INTO `shopmaster`.`producto` (`id`, `nombre`, `precio`) VALUES ('35', 'Zapatillas', '30€');
INSERT INTO `shopmaster`.`producto` (`id`, `nombre`, `precio`) VALUES ('36', 'Gafas de Sol', '15€');
INSERT INTO `shopmaster`.`producto` (`id`, `nombre`, `precio`) VALUES ('37', 'Colonia', '7€');
INSERT INTO `shopmaster`.`producto` (`id`, `nombre`, `precio`) VALUES ('38', 'Calcetines', '5€');
INSERT INTO `shopmaster`.`producto` (`id`, `nombre`, `precio`) VALUES ('39', 'Cinturon', '5€');
INSERT INTO `shopmaster`.`producto` (`id`, `nombre`, `precio`) VALUES ('40', 'Abrigo', '50€');

/* Productos_Tiendas */
INSERT INTO `shopmaster`.`productos_tiendas` (`id_producto`, `id_tienda`) VALUES ('1', '3');
INSERT INTO `shopmaster`.`productos_tiendas` (`id_producto`, `id_tienda`) VALUES ('2', '3');
INSERT INTO `shopmaster`.`productos_tiendas` (`id_producto`, `id_tienda`) VALUES ('3', '3');
INSERT INTO `shopmaster`.`productos_tiendas` (`id_producto`, `id_tienda`) VALUES ('4', '3');
INSERT INTO `shopmaster`.`productos_tiendas` (`id_producto`, `id_tienda`) VALUES ('5', '3');
INSERT INTO `shopmaster`.`productos_tiendas` (`id_producto`, `id_tienda`) VALUES ('6', '3');
INSERT INTO `shopmaster`.`productos_tiendas` (`id_producto`, `id_tienda`) VALUES ('7', '3');
INSERT INTO `shopmaster`.`productos_tiendas` (`id_producto`, `id_tienda`) VALUES ('8', '3');
INSERT INTO `shopmaster`.`productos_tiendas` (`id_producto`, `id_tienda`) VALUES ('9', '3');
INSERT INTO `shopmaster`.`productos_tiendas` (`id_producto`, `id_tienda`) VALUES ('10', '3');
INSERT INTO `shopmaster`.`productos_tiendas` (`id_producto`, `id_tienda`) VALUES ('11', '4');
INSERT INTO `shopmaster`.`productos_tiendas` (`id_producto`, `id_tienda`) VALUES ('12', '4');
INSERT INTO `shopmaster`.`productos_tiendas` (`id_producto`, `id_tienda`) VALUES ('13', '4');
INSERT INTO `shopmaster`.`productos_tiendas` (`id_producto`, `id_tienda`) VALUES ('14', '4');
INSERT INTO `shopmaster`.`productos_tiendas` (`id_producto`, `id_tienda`) VALUES ('15', '4');
INSERT INTO `shopmaster`.`productos_tiendas` (`id_producto`, `id_tienda`) VALUES ('16', '4');
INSERT INTO `shopmaster`.`productos_tiendas` (`id_producto`, `id_tienda`) VALUES ('17', '4');
INSERT INTO `shopmaster`.`productos_tiendas` (`id_producto`, `id_tienda`) VALUES ('18', '4');
INSERT INTO `shopmaster`.`productos_tiendas` (`id_producto`, `id_tienda`) VALUES ('19', '4');
INSERT INTO `shopmaster`.`productos_tiendas` (`id_producto`, `id_tienda`) VALUES ('20', '4');
INSERT INTO `shopmaster`.`productos_tiendas` (`id_producto`, `id_tienda`) VALUES ('21', '4');
INSERT INTO `shopmaster`.`productos_tiendas` (`id_producto`, `id_tienda`) VALUES ('22', '4');
INSERT INTO `shopmaster`.`productos_tiendas` (`id_producto`, `id_tienda`) VALUES ('23', '4');
INSERT INTO `shopmaster`.`productos_tiendas` (`id_producto`, `id_tienda`) VALUES ('24', '4');
INSERT INTO `shopmaster`.`productos_tiendas` (`id_producto`, `id_tienda`) VALUES ('25', '4');
INSERT INTO `shopmaster`.`productos_tiendas` (`id_producto`, `id_tienda`) VALUES ('1', '6');
INSERT INTO `shopmaster`.`productos_tiendas` (`id_producto`, `id_tienda`) VALUES ('3', '6');
INSERT INTO `shopmaster`.`productos_tiendas` (`id_producto`, `id_tienda`) VALUES ('4', '6');
INSERT INTO `shopmaster`.`productos_tiendas` (`id_producto`, `id_tienda`) VALUES ('6', '6');
INSERT INTO `shopmaster`.`productos_tiendas` (`id_producto`, `id_tienda`) VALUES ('7', '6');
INSERT INTO `shopmaster`.`productos_tiendas` (`id_producto`, `id_tienda`) VALUES ('8', '6');
INSERT INTO `shopmaster`.`productos_tiendas` (`id_producto`, `id_tienda`) VALUES ('9', '6');
INSERT INTO `shopmaster`.`productos_tiendas` (`id_producto`, `id_tienda`) VALUES ('11', '2');
INSERT INTO `shopmaster`.`productos_tiendas` (`id_producto`, `id_tienda`) VALUES ('13', '2');
INSERT INTO `shopmaster`.`productos_tiendas` (`id_producto`, `id_tienda`) VALUES ('15', '2');
INSERT INTO `shopmaster`.`productos_tiendas` (`id_producto`, `id_tienda`) VALUES ('17', '2');
INSERT INTO `shopmaster`.`productos_tiendas` (`id_producto`, `id_tienda`) VALUES ('19', '2');
INSERT INTO `shopmaster`.`productos_tiendas` (`id_producto`, `id_tienda`) VALUES ('21', '2');
INSERT INTO `shopmaster`.`productos_tiendas` (`id_producto`, `id_tienda`) VALUES ('23', '2');
INSERT INTO `shopmaster`.`productos_tiendas` (`id_producto`, `id_tienda`) VALUES ('25', '2');
INSERT INTO `shopmaster`.`productos_tiendas` (`id_producto`, `id_tienda`) VALUES ('26', '5');
INSERT INTO `shopmaster`.`productos_tiendas` (`id_producto`, `id_tienda`) VALUES ('26', '5');
INSERT INTO `shopmaster`.`productos_tiendas` (`id_producto`, `id_tienda`) VALUES ('27', '5');
INSERT INTO `shopmaster`.`productos_tiendas` (`id_producto`, `id_tienda`) VALUES ('28', '5');
INSERT INTO `shopmaster`.`productos_tiendas` (`id_producto`, `id_tienda`) VALUES ('30', '5');
INSERT INTO `shopmaster`.`productos_tiendas` (`id_producto`, `id_tienda`) VALUES ('31', '5');
INSERT INTO `shopmaster`.`productos_tiendas` (`id_producto`, `id_tienda`) VALUES ('32', '5');
INSERT INTO `shopmaster`.`productos_tiendas` (`id_producto`, `id_tienda`) VALUES ('33', '5');
INSERT INTO `shopmaster`.`productos_tiendas` (`id_producto`, `id_tienda`) VALUES ('34', '1');
INSERT INTO `shopmaster`.`productos_tiendas` (`id_producto`, `id_tienda`) VALUES ('35', '1');
INSERT INTO `shopmaster`.`productos_tiendas` (`id_producto`, `id_tienda`) VALUES ('36', '1');
INSERT INTO `shopmaster`.`productos_tiendas` (`id_producto`, `id_tienda`) VALUES ('37', '1');
INSERT INTO `shopmaster`.`productos_tiendas` (`id_producto`, `id_tienda`) VALUES ('38', '1');
INSERT INTO `shopmaster`.`productos_tiendas` (`id_producto`, `id_tienda`) VALUES ('39', '1');
INSERT INTO `shopmaster`.`productos_tiendas` (`id_producto`, `id_tienda`) VALUES ('40', '1');
INSERT INTO `shopmaster`.`productos_tiendas` (`id_producto`, `id_tienda`) VALUES ('27', '1');
INSERT INTO `shopmaster`.`productos_tiendas` (`id_producto`, `id_tienda`) VALUES ('31', '1');
INSERT INTO `shopmaster`.`productos_tiendas` (`id_producto`, `id_tienda`) VALUES ('34', '5');
INSERT INTO `shopmaster`.`productos_tiendas` (`id_producto`, `id_tienda`) VALUES ('36', '5');
INSERT INTO `shopmaster`.`productos_tiendas` (`id_producto`, `id_tienda`) VALUES ('38', '5');
INSERT INTO `shopmaster`.`productos_tiendas` (`id_producto`, `id_tienda`) VALUES ('40', '5');




