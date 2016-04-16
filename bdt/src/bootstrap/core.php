<?php 
require_once ROOT_APP . '/src/bootstrap/autoload.php';

use Src\Bootstrap\Classes\Controller;
use Src\Bootstrap\Classes\Connection;


Class BDTApp {
  public static $component;

  public static function run() {
    $route = Controller::getRoute();

    $controller = ucfirst($route['controller']).'Controller';
    $action = $route['action'];
    
    

    if( is_file(ROOT_APP . '/src/controllers/' .$controller. '.php')) {
      require_once ROOT_APP . '/src/controllers/' .$controller. '.php';

      $controller = 'Src\\Controllers\\'.$controller;

      $instance = new $controller;
      $instance->$action();
    }
  }

  public static function __callStatic($method, $params) {
    
    try {
      if(static::$component[$method]) {
        return static::$component[$method];
      }
      
      throw new Exception("Mehtod doesn't exists");

    } catch (Exception $e) {
      echo $e->getMessage();
    }
  }

}

BDTApp::$component['DB'] =& new Connection(Autoload::$config);


// class BDTApp {
//   public static function run() {
//     // $class = new self(Autoload::$classMap);
//     // $class->loadModule();


//     preg_match_all('/^path=(.*)&/', $_SERVER['QUERY_STRING'], $path);
//     // $render = (sizeOf($path[1]) < 1) ? 'bdt/index' : $path[1][0];

//     // $app_action = explode('/', $render);

//     // switch(sizeOf($app_action)) {
//     //   case 2:
//     //     $controller = $app_action[0];
//     //     $action = $app_action[1];
//     //     break;
//     //   case 1:
//     //     $controller = 'bdt';
//     //     $action = $render;
//     //     break;
//     //   default:
//     //     $controller = 'bdt';
//     //     $action = 'index';
//     // }
  
//     var_dump(Controller::getRoute());
//     exit();

//     $render = self::getRoute();
    
//     $defaultLayout = 'layout';
//     $vpath = VIEW_PATH . DIRECTORY_SEPARATOR;

//     $view_datas = array(
//       'yield' => ''
//     );

//     require_once ROOT_APP . '/src/process.php';

//     if(file_exists( $vpath. $action . '.php')) {
      
//       $view_datas['yield'] = $vpath. $action . '.php';
      
//       extract($view_datas);
//       require_once VIEW_PATH . DIRECTORY_SEPARATOR . $defaultLayout . '.php';  
//       die();
//     } 
    
//     extract($view_datas);
//     require_once VIEW_PATH . DIRECTORY_SEPARATOR . 'layout.php';
//   }

