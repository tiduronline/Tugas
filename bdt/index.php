<?php  
define('ROOT_APP', dirname(__FILE__));
require_once ROOT_APP . '/src/bootstrap/autoload.php';

use Src\Bootstrap\Classes\Connection;

$responses = NULL;

if(isset($_GET['id'])) {
  $server = substr($_GET['id'], 0, 1);

  $DB = new Connection('root', 'admin', 'bdt', $configs['Databases'][$server]);
  $ret = $DB->getAll('select * from categories');

  $responses = array(
    'server' => $configs['Databases'][$server],
    'ret' => $ret,
  );
} 
?>
<html>
<head>
  <title>Tugas BDT</title>
</head>
<body>
<ul>
  <li><a href="?id=12313221">ambil dari server 1</a> </li>
  <li><a href="?id=2323232">ambil dari server 2</a> </li>
</ul>

<?php if($responses):  ?>

  IP Server: <?php echo $responses['server']; ?></br>
  Data result:
  <pre>
    <?php print_r($responses['ret']) ?>
  </pre>

<?php endif; ?>

</body>
</html>




