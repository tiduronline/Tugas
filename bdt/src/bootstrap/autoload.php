<?php 
/**
 * Simple Autoload Class
 *
 * Verri Andriawan < verri@tiduronline.com >
 * April 6th, 2016
 */


Class Autoload {
  public static $classMap; 

  public static function load($class) {

    // Load Core
    foreach(static::$classMap['Namespaces'] as $alias => $file) {
      
      $file = strtr($file, '\\' , DIRECTORY_SEPARATOR). '.php';
      $dir = dirname($file . '.php');
      $filename = basename($file);

      if( !class_exists(substr($filename, 0, -4))) {
        includeFile(ROOT_APP . strtolower($dir) . DIRECTORY_SEPARATOR . $filename);  
      }
      
    }

    return true;
  }
}

function includeFile($file) {
  require_once $file;
}

Autoload::$classMap = require(ROOT_APP . '/src/config.php');
spl_autoload_register(['Autoload', 'load']);