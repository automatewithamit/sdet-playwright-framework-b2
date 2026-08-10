Component of a Test Automation Framework
    -  Maven - Build and Dependency Management
    -  TestNG - Create Manage and Execute Test Cases
    -  Playwright
    -  Allure Report



Project is present locally in the below path:
    -  C:\Users\Dell\Desktop\Test Automation Framework


Automation Execution Infrastructure: ( Automation Execution Evolution )
    -  Phase 1 -> Local Execution - Execute Test Cases on Local Machine  
    -  Phase 2 -> Physical Device Execution - Trigger Test Cases on Physical Devices, there won't be any interference from the local machine, and the execution will be done on the physical device.
    -  Phase 3 -> Automating the Test Triggering Process - Automate the process of triggering the test cases on physical devices, eliminating the need for manual intervention.
                    Batch file ->  Windows Batch File, Windows Scheduler.
    -  Phase 4 -> VMs -> Execute Test Cases on Virtual Machines, allowing for parallel execution and better resource utilization.

    -  Selenium Grid - Distributed Test Execution
        - Hubs  --> Nodes ( VMs / Physical Devices / Cloud Devices -> example: BrowserStack, SauceLabs, etc. , EC2 Instances (AWS), Azure VMs, GCP, etc. )

    - Hypervisor - Virtualization Technology
        - VMWare Workstation / Oracle VirtualBox / Hyper-V
        - Windows Server 2019 / Windows Server 2022 / Linux OS (Ubuntu, CentOS, etc.)
        - Linux OS (Ubuntu, CentOS, etc.) - For running the test cases on virtual machines.
    

EC2 - 
    -  AWS EC2 Instances - Cloud-based Virtual Machines for Test Execution
    -  AWS S3 Bucket - Store Test Artifacts and Reports
    -  AWS Lambda - Serverless Computing for Test Execution
    -  AWS CloudWatch - Monitor Test Execution and Logs

IAM -  AWS Identity and Access Management (IAM) - Manage User Access and Permissions for Test Execution





CI/CD Pipeline for Test Automation Framework: ( Continuous Integration and Continuous Delivery )


    -  differnt branch code --merged into ->  masterBranch -> build the application -> execute the tests



Jenkins Pipeline for Test Automation Framework -> Orchestration of the Test Execution Process
    - Github - Version Control System
    - Maven - Build and Dependency Management
    - Build and Test Execution - Execute Test Cases on Local Machine, Physical Devices, VMs, and Cloud Devices
    - Allure Report - Generate Test Execution Reports

    -  Jenkins - Continuous Integration and Continuous Delivery
    -  Docker - Containerization of the Application
    -  GitHub - Version Control System



local Project --> Github -->  
