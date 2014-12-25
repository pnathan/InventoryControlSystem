# -*- mode: ruby -*-
# vi: set ft=ruby :

# Vagrantfile API/syntax version. Don't touch unless you know what you're doing!
VAGRANTFILE_API_VERSION = "2"

Vagrant.configure(VAGRANTFILE_API_VERSION) do |config|
  config.vm.box = "ubuntu/trusty64"
  config.vm.provider "virtualbox" do |v|
    v.memory = 1024
    v.cpus = 2
  end

  # accessing "localhost:9000" will access port 9000 on the guest machine.

  # Activator run runs on 9000
  config.vm.network "forwarded_port", guest: 9000, host: 9000
  # postgres listens on 5432
  config.vm.network "forwarded_port", guest: 5432, host: 54320

  # get a puppet pg class setup
  config.vm.provision :shell, inline:  "puppet module install --force puppetlabs-postgresql"

  config.vm.provision :puppet do |puppet|
    puppet.manifests_path = "vagrant/manifests"
    puppet.manifest_file  = "default.pp"
  end

end
