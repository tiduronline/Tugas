<?php 
namespace Src\Controllers;

use Src\Bootstrap\Classes\Controller;
use Src\Bootstrap\Classes\Requests;
use BDTApp;

class CustomerController extends Controller {

  public function actIndex() {

    $customers = BDTApp::DB()->getAll('customers');

    $this->render();
  }

  /**
   * Add Customer
   */
  public function actAdd() {
    
    if(Requests::getPost('codename')) {
      $key = "'".Requests::getPost('codename')."'";

      // check the code
      $customer = BDTApp::DB()->getOneByKey($key, 'codename', 'customers');
      
      if(!$customer) {
        $sql = "insert into customers (`codename`, `flag`) values ('".Requests::getPost('codename')."', 1)";

        BDTApp::DB()->executeByKey(Requests::getPost('codename'), $sql);
        $customer = BDTApp::DB()->getOneByKey($key, 'codename', 'customers');
      }

      if(!$customer['flag']) {
        $query = "update customers set flag=1";
        BDTApp::DB()->executeByKey(Requests::getPost('codename'), $query);
      }

      $datas = array( 'customer' => $customer );
      $this->render($datas, 'edit');
    }

    $this->render();
  }

  /**
   * Edit Customer
   */

  public function actEdit() {
    $key = "'".Requests::getGet('codename')."'";
    $customer = BDTApp::DB()->getOneByKey($key, 'codename', 'customers');

    if(isset($customer['flag']) && ($customer['flag'])) {
      die('Ada session lain yang sedang mengedit');
    }
    // BDTApp::DB()->setUpdate($key, array( 'flag' => 1 ), 'customers');

    $this->render(array('customer' => $customer));
  }


  /**
   * Update Customer
   */
  public function actUpdate() {
    if(Requests::getPost('id') && Requests::getPost('codename')) {
      $query = array();
      $int = array('id', 'gender');
      $protected = array('id', 'codename');

      unset($_POST[strtolower($this->__activeController)]);

      foreach(Requests::getPost() as $field => $value ) {

        if(!in_array($field, $protected)) {
          if(isset($value)) {
            if(!in_array($field, $int) ) {
              $value = "'{$value}'";
            } 
            array_push($query, "{$field}=$value");
          }
        }

      }
      array_push($query, 'flag=0');


      $query = implode(', ', $query);
      $query = "update customers set ".$query." where codename='".Requests::getPost('codename')."'";
      
      $resp = BDTApp::DB()->executeByKey(Requests::getPost('codename'), $query);  
      
      if($resp) {
       $this->redirect('customer/add');  
       return true;
      }

      $params = array(
        'customer' => Requests::getPost()
      );

      $this->render($params, 'edit');
      
    }

    die('Update failed');
  }

}