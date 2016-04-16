<?php 
namespace Src\Controllers;

use Src\Bootstrap\Classes\Controller;
use Src\Bootstrap\Classes\Requests;
use BDTApp;

class BdtController extends Controller {
  
  public function actIndex() {
    $this->redirect('customer/add');
  }

}
