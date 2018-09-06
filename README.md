An example using [Jib](https://github.com/GoogleContainerTools/jib) to
deploy an OpenWhisk action -- using a
[slightly-hacked](https://github.com/jcrossley3/incubator-openwhisk-runtime-java/tree/knative)
runtime -- to a Knative cluster.

Note the `jib-maven-plugin` configuration in the [pom.xml](pom.xml)
that uses our runtime as a base image. We must also replicate its
entrypoint in that config.

After installing the [jib build
template](https://github.com/knative/build-templates/tree/master/jib)
to your knative cluster, you can then apply [hello.yaml](hello.yaml)
to deploy the hello service.

Once the build pod completes, you can test the service like so:

    IP=$(kubectl get svc knative-ingressgateway -n istio-system -o jsonpath="{.status.loadBalancer.ingress[*].ip}")
    HOST=$(kubectl get route hello -o jsonpath="{.status.domain}")

    curl -d '{"name":"Jeff"}' -H "Host: $HOST" http://$IP
