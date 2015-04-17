# Teaching-HEIGVD-RES-2015-Vagrant
A repo containing the Vagrant-based environment (including code samples)


## Windows users

### Encoding error

Further reading about the issue: 

- https://github.com/mitchellh/vagrant/issues/2885
- https://github.com/mitchellh/vagrant/issues/2113

```
Bringing machine 'default' up with 'virtualbox' provider...
[default] Box 'precise32' was not found. Fetching box from specified URL for
the provider 'virtualbox'. Note that if the URL does not have
a box for this provider, you should interrupt Vagrant now and add
the box yourself. Otherwise Vagrant will attempt to download the
full box prior to discovering this error.
Downloading box from URL: http://files.vagrantup.com/precise32.box
C:/HashiCorp/Vagrant/embedded/gems/gems/childprocess-0.3.9/lib/childprocess/wind
ows/process_builder.rb:63:in `join': incompatible character encodings: CP850 and
 ASCII-8BIT (Encoding::CompatibilityError)
```

For the users who have non ASCII caracters in their user names, you should follow these instructions to fix the issue:

```
# Set the following environment variables
setx VAGRANT_HOME "X:\your\path\vagrant"
setx GEM_HOME "X:\your\path\gems"
```

You must create the folders somewhere. We propose the following structure:

```
Drive:
 |- vagrant
   |- vagrant
   |- gems
```
