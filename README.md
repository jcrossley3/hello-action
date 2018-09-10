A failed attempt using
[Jib](https://github.com/GoogleContainerTools/jib) to deploy an Fn
action -- using a [small Undertow
proxy](https://github.com/jcrossley3/undertowfn) -- to a Knative
cluster.

Note the `jib-maven-plugin` configuration in the [pom.xml](pom.xml)
that uses our runtime as a base image. We can specify a default Fn
there which may be overridden by the yaml referencing it.

After installing the [jib build
template](https://github.com/knative/build-templates/tree/master/jib)
and [your DockerHub
credentials](https://github.com/jcrossley3/openwhisk-scratch/blob/master/build-creds.yaml)
to your knative cluster, you can then apply [hello.yaml](hello.yaml)
to deploy the hello service.

Once the build pod completes, you can test the service like so:

    IP=$(kubectl get svc knative-ingressgateway -n istio-system -o jsonpath="{.status.loadBalancer.ingress[*].ip}")
    HOST=$(kubectl get route hello -o jsonpath="{.status.domain}")

    curl -d '{"name":"Jeff"}' -H "Host: $HOST" http://$IP
