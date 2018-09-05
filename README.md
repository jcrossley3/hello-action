An example of using [Jib](https://github.com/GoogleContainerTools/jib)
to deploy an OpenWhisk action using a slightly-hacked runtime.

Note the `jib-maven-plugin` configuration in the [pom.xml](pom.xml)
that uses our slightly-hacked OpenWhisk java runtime as a base image.
We also must replicate its entrypoint in that config.

After installing the [jib build
template](https://github.com/knative/build-templates/tree/master/jib)
to your knative cluster, you can then apply [hello.yaml](hello.yaml)
to deploy the hello service.
