<?php use Src\Bootstrap\Classes\Requests; ?>

<div id="content" class="container">
  <div class="row">
    <div class="col s12">
      <h5>Input Profile Customer</h5>
    </div>

    <div class="col s12">
      <form action="<?php echo $this::buildRoute(array(), array('controller' => 'customer', 'action' => 'update' ));?>" method="POST">
        <label for="codename">Codename</label>
        <input id="codename" type="text" name="codename" value="<?php echo $customer['codename']?>" disabled="disabled" />

        <label for="name">Name</label>
        <input id="name" type="text" name="nama" value="<?php echo $customer['nama']?>" placeholder="Name" />

        <label for="address">Address</label>
        <textarea id="address" type="text" name="alamat" class="materialize-textarea" /><?php echo $customer['alamat']; ?></textarea>

        <label for="identity">Identity ID</label>
        <input id="identity" type="text" name="ktp" value="<?php echo $customer['ktp']; ?>" placeholder="No Identitas" />

        <label for="phone">Phone</label>
        <input id="Phone" type="text" name="telephone" value="<?php echo $customer['telephone']; ?>" placeholder="telephone" />

        <div class="input-field col s12">
          <label for="gender">Gender</label>
          <select id="gender" name="gender" class="input-field col s12">
            <option value="1">Pria</option>
            <option value="2">Wanita</option>
          </select>
        </div>

        <input type="hidden" name="customer" value="1" />
        <input type="hidden" name="codename" value="<?php echo $customer['codename']?>" />
        <input type="hidden" name="id" value="<?php echo $customer['id']; ?>">
        <button class="waves-effect waves-light btn">Update Customer</button>
      </form>
    </div>
  </div>
</div>