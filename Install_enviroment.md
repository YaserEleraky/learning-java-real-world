# 1. Clean up old broken files from your folder
rm -f amazon-corretto-21*

# 2. Make sure the system is ready to process Java installer configurations
sudo apt-get update && sudo apt-get install -y java-common

# 3. Download the real 160MB package by forcing curl to follow redirects (-L)
curl -L -O https://corretto.aws/downloads/latest/amazon-corretto-21-x64-linux-jdk.deb

# 4. Verify that the file size is now much larger than 7KB (should be ~160,000,000 bytes)
ls -la amazon-corretto-21-x64-linux-jdk.deb

# 5. Install the package natively inside your WSL system
sudo dpkg -i amazon-corretto-21-x64-linux-jdk.deb

# 6. Delete the installer file to reclaim disk space
rm amazon-corretto-21-x64-linux-jdk.deb
