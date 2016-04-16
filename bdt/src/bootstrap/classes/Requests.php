<?php 
namespace Src\Bootstrap\Classes;

use Src\Bootstrap\Classes\Controller;

class Requests {


  /**
   * Filter POST
   * 
   * @var model
   */
  public function getPost($model = NULL ) {
    preg_match_all('/(.*)\[(.*)\]/', $model, $path);
    if(!empty($path[2][0])) {

      if( isset($_POST[$path[1][0]]) &&
          isset($_POST[$path[1][0]][$path[2][0]]) ) 
      {

        return $_POST[$path[1][0]][$path[2][0]];  
      }
      
      return NULL;
    }


    if(isset($_POST[$model])) {
      return $_POST[$model];
    }

    if(is_null($model)) {
      return $_POST;
    }
    return NULL;
  }


  /**
   * Filter GET
   *
   * @var model
   */
  public static function getGet($model = NULL ) {
    preg_match_all('/(.*)\[(.*)\]/', $model, $path);
    if(!empty($path[2][0])) {

      if( isset($_GET[$path[1][0]]) &&
          isset($_GET[$path[1][0]][$path[2][0]])) 
      {
        return $_GET[$path[1][0]][$path[2][0]];  
      }

      return NULL;
    }
    
    if(isset($_GET[$model])) {
      return $_GET[$model];
    }

    if(is_null($model)) {
      return $_POST;
    }
    
    return NULL;
  }

}