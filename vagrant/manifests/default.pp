class { 'postgresql::server':
  ip_mask_deny_postgres_user => '0.0.0.0/32',
  ip_mask_allow_all_users    => '0.0.0.0/0',
  listen_addresses           => '*',

  ipv4acls                   =>
  # trust vagrant ssh connections
  ['local all all trust',
   # trust IP connections from VM
   'host all all 127.0.0.1/24 trust',
   # trust IP connections from host
   'host all all 10.0.0.0/32 trust'],
  postgres_password          => 'postgres',
}


postgresql::server::db { 'inventory_control_system':
  user     => 'inventory_control_system_user',
  password => postgresql_password('inventory_control_system_user', 'dev-password')
}


package { "openjdk-7-jre-headless": ensure => 'latest' }
package { "openjdk-7-jdk": ensure => 'latest' }
