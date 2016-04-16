<?php 
namespace Src\Bootstrap\Classes;

/**
 * Verri Andriawan < verri@tiduronline.com >
 * April 6th, 2016
 */

Class Connection {

  /**
   * @var PDO Connection
   */
  private $__connection = NULL;
  private $__active = NULL;
  private $__config = NULL;

  public function __construct( $config ) {
    $this->config = $config;
  }
  

  public function connect($name = NULL) {
    $this->prepare($name);
    return $this->__connection[$name];
  }

  public function server( $server = NULL ) {
    $this->connect($server);
    return $this;
  }

  public function prepare( $name = NULL ) {
    $name = $name ? $name : '1';
    $this->__active = $name;

    if(!isset($this->__connection[$name])) {
      if(isset($this->config['Databases'][$name])) {
        $this->__connection[$name] = $this->getPdo($this->config['Databases'][$name]);
        return true;
      }

      die('Server configuration not found');
    } 
  }

  private function __descServer($key = NULL) {
    if($key) {
      $server = substr($key, 0, 1);

      return $server;
    }


    return NULL;
  }


/**
 * Query
 * -------------------------------------------------  
 */
  
  public function executeByKey($key =NULL, $query=NULL) {
    if(!$key) {
      die('Primary Key not found');
    }

    $this->__active = $this->__descServer($key);
    return $this->execute($query);
  }

  public function execute($sql = NULL) {
    if(!$sql) {
      return false;
    }

    if(!isset($this->__connection[$this->__active])) {
      $this->connect($this->__active);
    }

    $con = $this->__connection[$this->__active]->prepare($sql);
    return $con->execute();
  }


  public function getOneByKey($key = NULL, $field = NULL, $table = NULL, $select = '*', $condition = array()) {
    if(!isset($key) || !isset($field)){
      return false;
    }
    $this->__active = $this->__descServer($key);

    return $this->getOne($key, $field, $table, $select, $condition);
  }


  public function getOne($key = NULL, $field = NULL, $table = NULL, $select = '*', $condition = array()) {

    if(!isset($key) || !isset($field)) {
      return false;
    }

    $this->prepare();

    if(!$table) {
      die('Table should be provided');
    }
    
    $sql = 'select '.$select.' from '.$table.' where '.$field.'='.$key;
    
    if((sizeOf($condition) > 0) && is_array($condition)) {
      $sql .= ' and ';
      foreach($condition as $k => $v) {
        $sql .= "{$k}='{$v}'";
      }
    }
    $con = $this->__connection[$this->__active]->prepare($sql);
    $con->execute();

    $resp = $con->fetch(\PDO::FETCH_ASSOC);

    return $resp;
  }


  public function getAll($table = NULL, $condition = NULL, $limit = NULL) {
    $sql = 'select * from '.$table;
    
    if((sizeOf($condition) > 0) && is_array($condition)) {
      $sql .= ' where ';
      foreach($condition as $k => $v) {
        $sql .= " {$k}='{$v}' and";
      }
      $sql = preg_replace('/and$/', '', $sql);
    }

    if($limit) {
      $sql .= ' limit '.$limit;
    }

    $resp = $this->__connection[$this->__active]->query($sql);
    return $resp->fetchAll();
  }

  
  // private
  private function getPdo($config) {

    try {
      $conn = new \PDO('mysql:host=' .$config['host']. ';dbname=' .$config['dbname']. ';charset=utf8mb4', $config['user'], $config['pass'], array(
        \PDO::ATTR_TIMEOUT => 3,
        \PDO::ATTR_ERRMODE => \PDO::ERRMODE_EXCEPTION,
      ));
    } catch (\Exception $e ) {
      die($e->getMessage());
    }

    return $conn;
  }

}

