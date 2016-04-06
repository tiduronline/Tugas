<?php 
/**
 * Verri Andriawan < verri@tiduronline.com >
 * April 6th, 2016
 */

namespace Src\Bootstrap\Classes;

Class Connection {

  public $user;
  public $pass;
  public $dbname;
  public $host;
  public $port;

  /**
   * @var PDO Connection
   */
  private $__connection = NULL;

  public function __construct( $user, $password, $dbname, $host = '127.0.0.1', $port = 3306) {
    $this->user = $user;
    $this->password = $password;
    $this->dbname = $dbname;
    $this->host = $host;
    $this->port = $port;
  }

  public function open() {
    if($this->__connection == NULL) {
      $this->__connection = new \PDO('mysql:host=localhost;dbname=' .$this->dbname. ';charset=utf8mb4', $this->user, $this->password);
    }
  }


  public function connect() {
    $this->open();
    return $this->__connection;
  }

  public function getAll($sql) {
    $resp =  $this->connect()->query($sql);

    return $resp->fetchAll();
  }
}