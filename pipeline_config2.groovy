libraries:
  - maven
  - sonarqube
  - ansible

allow_scm_jenkinsfile: true

application_environments:
  dev:
    ip_addresses:
      - 192.168.1.1
      - 192.168.1.2
    long_name: Development Environment
  prod:
    ip_addresses:
      - 10.0.0.1
    long_name: Production Environment
