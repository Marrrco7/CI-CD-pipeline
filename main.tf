terraform {
  required_providers {
    kind = {
      source = "tehcyx/kind"
      version = "0.6.0"
    }
  }
}

provider "kind" {}

resource "kind_cluster" "default" {
  name           = "challenge"
  node_image = "kindest/node:v1.30.4"
  wait_for_ready = true

  kind_config {
    kind        = "Cluster"
    api_version = "kind.x-k8s.io/v1alpha4"

    node {
      role = "control-plane"

      kubeadm_config_patches = [
        "kind: InitConfiguration\nnodeRegistration:\n  kubeletExtraArgs:\n    node-labels: \"ingress-ready=true\"\n"
      ]

      extra_port_mappings {
        container_port = 80
        host_port      = 80
      }
      extra_port_mappings {
        container_port = 443
        host_port      = 443
      }
    }
    node {
      role = "worker"
    }
    node {
      role = "worker"
    }
    node {
      role = "worker"
    }
  }
}

