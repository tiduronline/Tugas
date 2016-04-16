<?php 
namespace Src\Bootstrap\Classes;

use Src\Bootstrap\Classes\Requests;


Class Controller {
  public $layout = 'layout';
  public $theme = '/src/views/';

  protected $__activeController = 'bdt';
  protected $__actionActive = 'index';

  
  /**
   * Parsing url Path 
   *
   */
  public static function getRoute() {
    
    $path = (Requests::getGet('path')) ? Requests::getGet('path') : 'bdt/index';
    $router = array();

    if(!empty($path)){
      $app_action = explode('/', $path);  

      if(sizeOf($app_action) < 2) {
        $router['controller'] = 'bdt';
        $router['action'] = $app_action[0];
      } else {
        $router['controller'] = $app_action[0];;
        $router['action'] = $app_action[1];
      }
    }
    
    return $router;
  }


  /**
   * Rendering
   */

  public function render( $datas = array(), $template = NULL ) {

    $view = $this->__actionActive;

    if($template) {
      $view = $template;
    }

    $ctrl = (strtolower($this->__activeController) === 'bdt') ? 'main' : strtolower($this->__activeController);
    $ctrl .= DIRECTORY_SEPARATOR;
    $vpath = ROOT_APP.$this->theme;
    
    if(is_file($vpath.$ctrl.$view. '.php')) {
      $datas = array_merge($datas, array('yield' => $vpath.$ctrl.$view. '.php') );
      extract($datas);
      require_once $vpath.'layout.php';
    } else {
      die('Make sure that view file is exists');
    }
  }

  /**
   * Build Router
   */
  public function buildRoute(Array $params, $application = array()) {

    if(isset($application['controller'])) {
      $controller = $application['controller'];
      $action = $application['action'];
    } else {
      $route = self::getRoute();

      $controller = $route['controller'];
      $action = $route['action'];
    }
    
    $query = array( 'path' => $controller.'/'.$action );
    $params = array_merge($query, $params);

    if(sizeOf($params) > 0) {
      $query = http_build_query($params);
    }
    $query = preg_replace('/%2F/', '/', $query);
    $url = HOSTNAME.'/?'.$query;
       
    return $url;
  }



  /**
   * Redirected
   */
  public function redirect($route) {


    header("Location: ". HOSTNAME.'/?path='.$route);
  }


  /**
   * Check Method
   */
  public function __call( $method, $params ) {

    $controller = get_class($this);
    $controller = preg_replace('/\\\/','/',$controller);
    $info = pathinfo($controller);
    
    $this->__activeController = preg_replace('/Controller$/','',$info['basename']);
    unset($info);

    $this->__actionActive = $method;
    if( method_exists($this, 'act'.ucfirst($method)) ) {
      return call_user_func_array(array($this, 'act'.ucfirst($method)), $params);
    }
  }




}



