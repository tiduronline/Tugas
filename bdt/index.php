<?php  
/**
 * Dedicated build for DDB ( Distribution database ) Examination
 *
 * Verri Andriawan < verri@tiduronline.com >
 * 14th April 2016
 */

define('ROOT_APP', dirname(__FILE__));
define('VIEW_PATH', ROOT_APP . '/src/views');
define('HOSTNAME', 'http://localhost/bdt');

require_once ROOT_APP . '/src/bootstrap/core.php';

BDTApp::run();

