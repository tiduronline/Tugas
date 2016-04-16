<?php 
/**
 * Verri Andriawan < verri@tiduronline.com >
 * April 6th, 2016
 */

$configs = array(

  // Cores
  'Namespaces' => array(
    'CoreController' => '\Src\Bootstrap\Classes\Controller',
    'CoreQuery' => '\Src\Bootstrap\Classes\Query',
    'CoreRequests' => '\Src\Bootstrap\Classes\Requests',
    'DB' => '\Src\Bootstrap\Classes\Connection',
  ),

  // Database Host
  'Databases' => array(

    // Database 1
    '1' => array(
      'user' => 'admin',
      'pass' => 'admin',
      'dbname' => 'bdt',
      'host' => '127.0.0.1',
      'port' => 3306,
    ),

    // Database 2
    '2' => array(
      'user' => 'admin',
      'pass' => 'admin',
      'dbname' => 'bdt',
      'host' => '10.200.126.227',
      'port' => 3306,
    )

  ),

);

return $configs;