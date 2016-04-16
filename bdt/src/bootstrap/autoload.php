<?php 
/**
 * Simple Autoload Class
 *
 * Verri Andriawan < verri@tiduronline.com >
 * April 6th, 2016
 */

Class Autoload {
  public static $config; 
  private static $__namespaces = NULL;
  
  public function __construct() {
    
    /**
     * List all core
     */
    if(static::$__namespaces == NULL) {
      foreach(static::$config['Namespaces'] as $alias => $namespace) {
        $file = strtr($namespace, '\\' , DIRECTORY_SEPARATOR). '.php';
        $pathinfo = pathinfo($file);
                
        $dir = strtolower($pathinfo['dirname']);
        $ext = $pathinfo['extension'];
        $class = $pathinfo['filename'];

        static::$__namespaces[$namespace] = ROOT_APP. $dir.DIRECTORY_SEPARATOR.$class. '.' .$ext;
      }
    }

  }

/**
 * Autoload
 */
  public function register() {
    spl_autoload_register(array($this, 'loadClass'), true, true);
  }


/**
 * LoadClass
 */
  public static function loadClass($class) {
    $class = '\\'.$class;
    if(isset(static::$__namespaces[$class]) && is_file(static::$__namespaces[$class])) {
      includeFile(static::$__namespaces[$class]);

      return true;
    }
    return false;
  }

}

function includeFile($file) {
  include $file;
}


Autoload::$config = require(ROOT_APP . '/src/config.php');
(new Autoload)->register();




