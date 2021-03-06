# script for modify the user permissions for the sakuli installation dir
# if no arguments are assigned, will fail

###### parsing arguments
param([string]$pathValue = $null)
#e. g. $path = "C:\sakuli\"

if (! $pathValue){
	Write-Error "first argument have to be the path to set the user permissions"
	exit
}
set-strictmode -version Latest

###### functions & parameters:
$username = $Env:USERNAME
$rule=new-object System.Security.AccessControl.FileSystemAccessRule($username,"FullControl","Allow")
foreach ($file in $(Get-ChildItem $pathValue -recurse -Force)) {
  $acl=get-acl $file.FullName
 
  #Add this access rule to the ACL
  $acl.SetAccessRule($rule)
  
  #Write the changes to the object
  set-acl $File.Fullname $acl
}

echo "Folder Permissions of '$pathValue' update sucessfully for user '$username'!"
exit